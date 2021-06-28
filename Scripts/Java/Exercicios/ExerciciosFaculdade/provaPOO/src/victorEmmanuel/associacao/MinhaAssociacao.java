package victorEmmanuel.associacao;

import java.util.ArrayList;

public class MinhaAssociacao implements InterfaceAssociacao {

    private ArrayList<Associacao> associacoes = new ArrayList<Associacao>();

    @Override
    public void adicionar(Associacao a) throws AssociacaoJaExistente, ValorInvalido {

        if (a.getNum() < 0 || a.getNome().isEmpty()) {
            throw new ValorInvalido();
        }

        for (Associacao associacaoAtual : associacoes) {
            if (associacaoAtual.getNum() == a.getNum()) {
                throw new AssociacaoJaExistente();
            }
        }

        associacoes.add(a);
    }

    @Override
    public void adicionar(int associacao, Associado a) throws AssociacaoNaoExistente, AssociadoJaExistente, ValorInvalido {
        if (a.getNumero() < 0 || a.getNome().isEmpty() || a.getDataAssociacao() <= 0 || a.getNascimento() <= 0 || a.getTelefone().isEmpty()) {
            throw new ValorInvalido();
        }

        Associacao associacaoDesejada = verificaAssociacao(associacao);
        try {
            associacaoDesejada.pesquisaAssociado(a.getNumero());
            throw new AssociadoJaExistente();
        } catch (AssociadoNaoExistente e) {
            associacaoDesejada.adicionarAssociado(a);
        }
    }

    @Override
    public void adicionar(int associacao, Reuniao r) throws AssociacaoNaoExistente, ReuniaoJaExistente, ValorInvalido {
        if (r.getData() <= 0 || r.getAta().isEmpty()) {
            throw new ValorInvalido();
        }

        Associacao associacaoDesejada = verificaAssociacao(associacao);
        try {
            associacaoDesejada.pesquisaReuniao(r.getData());
            throw new ReuniaoJaExistente();
        } catch (ReuniaoNaoExistente e) {
            associacaoDesejada.adicionarReuniao(r);
        }
    }

    @Override
    public void adicionar(int associacao, Taxa t) throws AssociacaoNaoExistente, TaxaJaExistente, ValorInvalido {
        if (t.getVigencia() < 0 || t.getNome().isEmpty() || t.getParcelas() <= 0 || t.getValorAno() <= 0) {
            throw new ValorInvalido();
        }

        Associacao associacaoDesejada = verificaAssociacao(associacao);
        try {
            associacaoDesejada.pesquisaTaxa(t.getNome(), t.getVigencia());
            throw new TaxaJaExistente();
        } catch (TaxaNaoExistente e) {
            associacaoDesejada.adicionarTaxa(t);
        }
    }

    private Associacao verificaAssociacao(int numAssociacao) throws AssociacaoNaoExistente {
        for (Associacao associacaoAtual : associacoes) {
            if (associacaoAtual.getNum() == numAssociacao) {
                return associacaoAtual;
            }
        }
        throw new AssociacaoNaoExistente();
    }

    @Override
    public void registrarFrequencia(int codigoAssociado, int numAssociacao, long dataReuniao) throws AssociadoNaoExistente, ReuniaoNaoExistente, AssociacaoNaoExistente, FrequenciaJaRegistrada, FrequenciaIncompativel {
        Associacao associacao = verificaAssociacao(numAssociacao);

        Associado associado = associacao.pesquisaAssociado(codigoAssociado);

        Reuniao reuniao = associacao.pesquisaReuniao(dataReuniao);

        if (associado.getDataAssociacao() > reuniao.getData()) {
            throw new FrequenciaIncompativel();
        }

        try {
            reuniao.pesquisaParticipante(codigoAssociado);
            throw new FrequenciaJaRegistrada();
        } catch (AssociadoNaoExistente e) {
            reuniao.adicionarParticipante(associado);
        }
    }

    @Override
    public double calcularFrequencia(int numAssociado, int numAssociacao, long inicio, long fim) throws AssociadoNaoExistente, ReuniaoNaoExistente, AssociacaoNaoExistente {
        Associacao associacao = verificaAssociacao(numAssociacao);
       
        associacao.pesquisaAssociado(numAssociado);
        
        double reunioesParticipadas = 0.0;
        ArrayList<Reuniao> reunioesOcorridas = associacao.pesquisaReunioes(inicio, fim);
        for (Reuniao reuniaoAtual : reunioesOcorridas) {
        	try {
        		reuniaoAtual.pesquisaParticipante(numAssociado);
        		reunioesParticipadas++;
        	}catch (AssociadoNaoExistente e) {
				//Não há associado nessa reunião logo não precisa fazer nada
			}
        }
        return reunioesParticipadas / reunioesOcorridas.size();
    }

    //Falta a lógica para associados remidos
    @Override
    public void registrarPagamento(int numAssociacao, String taxa, int vigencia, int numAssociado, long data, double valor) throws AssociacaoNaoExistente, AssociadoNaoExistente, AssociadoJaRemido, TaxaNaoExistente, ValorInvalido {
        if (valor <= 0) {
            throw new ValorInvalido();
        }

        Associacao associacao = verificaAssociacao(numAssociacao);

        Associado associado = associacao.pesquisaAssociado(numAssociado);

        Taxa taxaDesejada = associacao.pesquisaTaxa(taxa, vigencia);

        taxaDesejada.pagamento(data, valor, associado);
       
    }

    @Override
    public double somarPagamentoDeAssociado(int numAssociacao, int numAssociado, String nomeTaxa, int vigencia, long inicio, long fim) throws AssociacaoNaoExistente, AssociadoNaoExistente, TaxaNaoExistente {
        Associacao associacao = verificaAssociacao(numAssociacao);

        Associado associado = associacao.pesquisaAssociado(numAssociado);

        Taxa taxaDesejada = associacao.pesquisaTaxa(nomeTaxa, vigencia);

        double valorPagamentos = 0.0;
        for (LogPagamento logAtual : taxaDesejada.getLogPagamento()) {
            if (logAtual.getAssociado().getNumero() == associado.getNumero() && logAtual.getData() >= inicio && logAtual.getData() <= fim) {
                valorPagamentos += logAtual.getValor();
            }
        }

        return valorPagamentos;
    }

    @Override
    public double calcularTotalDeTaxas(int numAssociacao, int vigencia) throws AssociacaoNaoExistente, TaxaNaoExistente {
        Associacao associacao = verificaAssociacao(numAssociacao);

        ArrayList<Taxa> taxasDesejadas = associacao.pesquisaTaxas(vigencia);

        double totalTaxasPrevistas = 0.0;
        for (Taxa taxaAtual : taxasDesejadas) {
            totalTaxasPrevistas += taxaAtual.getValorAno();
        }

        return totalTaxasPrevistas;
    }
}
