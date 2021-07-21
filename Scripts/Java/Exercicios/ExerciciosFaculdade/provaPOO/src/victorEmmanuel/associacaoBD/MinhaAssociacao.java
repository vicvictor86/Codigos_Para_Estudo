package victorEmmanuel.associacaoBD;

import java.sql.SQLException;
import java.util.ArrayList;

public class MinhaAssociacao implements InterfaceAssociacao {

	@Override
	public void adicionar(Associacao a) throws AssociacaoJaExistente, ValorInvalido {

		if (a.getNum() < 0 || a.getNome() == "" || a.getNome() == null) {
			throw new ValorInvalido();
		}

		DAOAssociacao daoAssociacao = new DAOAssociacao();
		try {
			for (Associacao associacaoAtual : daoAssociacao.recuperarTodos()) {
				if (associacaoAtual.getNum() == a.getNum()) {
					throw new AssociacaoJaExistente();
				}
			}
		} catch (SQLException e) {
			System.out.println("Error");
		}

		try {
			daoAssociacao.inserir(a);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Override
	public void adicionar(int associacao, Associado a)
			throws AssociacaoNaoExistente, AssociadoJaExistente, ValorInvalido {
		if (a.getNumero() < 0 || a.getNome() == "" || a.getDataAssociacao() <= 0 || a.getNascimento() <= 0
				|| a.getTelefone() == "" || a.getTelefone() == null || a.getNome() == null) {
			throw new ValorInvalido();
		}

		Associacao associacaoDesejada = verificaAssociacao(associacao);
		DAOAssociado daoAssociado = new DAOAssociado();
		try {
			associacaoDesejada.pesquisaAssociado(a.getNumero());
			throw new AssociadoJaExistente();
		} catch (AssociadoNaoExistente e) {
			try {
				daoAssociado.inserir(a, associacao);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}

	@Override
	public void adicionar(int associacao, Reuniao r) throws AssociacaoNaoExistente, ReuniaoJaExistente, ValorInvalido {
		if (r.getData() <= 0 || r.getAta() == "" || r.getAta() == null) {
			throw new ValorInvalido();
		}

		Associacao associacaoDesejada = verificaAssociacao(associacao);
		try {
			associacaoDesejada.pesquisaReuniao(r.getData());
			throw new ReuniaoJaExistente();
		} catch (ReuniaoNaoExistente e) {
			try {
				associacaoDesejada.adicionarReuniao(r, associacao);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}

	@Override
	public void adicionar(int associacao, Taxa t) throws AssociacaoNaoExistente, TaxaJaExistente, ValorInvalido {
		if (t.getVigencia() < 0 || t.getNome() == "" || t.getParcelas() <= 0 || t.getValorAno() <= 0
				|| t.getNome() == null) {
			throw new ValorInvalido();
		}

		Associacao associacaoDesejada = verificaAssociacao(associacao);
		try {
			associacaoDesejada.pesquisaTaxa(t.getNome(), t.getVigencia());
			throw new TaxaJaExistente();
		} catch (TaxaNaoExistente e) {
			DAOTaxa daoTaxa = new DAOTaxa();
			try {
				daoTaxa.inserir(t, associacao);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}

	private Associacao verificaAssociacao(int numAssociacao) throws AssociacaoNaoExistente {
		DAOAssociacao daoAssociacao = new DAOAssociacao();
		try {

			for (Associacao associacaoAtual : daoAssociacao.recuperarTodos()) {
				if (associacaoAtual.getNum() == numAssociacao) {
					return associacaoAtual;
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		throw new AssociacaoNaoExistente();
	}

	@Override
	public void registrarFrequencia(int codigoAssociado, int numAssociacao, long dataReuniao)
			throws AssociadoNaoExistente, ReuniaoNaoExistente, AssociacaoNaoExistente, FrequenciaJaRegistrada,
			FrequenciaIncompativel {
		Associacao associacao = verificaAssociacao(numAssociacao);

		Associado associado = associacao.pesquisaAssociado(codigoAssociado);

		Reuniao reuniao = associacao.pesquisaReuniao(dataReuniao);

		if (associado.getDataAssociacao() > reuniao.getData()) {
			throw new FrequenciaIncompativel();
		}

		try {
			reuniao.pesquisaFrequencia(codigoAssociado, dataReuniao);
			throw new FrequenciaJaRegistrada();
		} catch (AssociadoNaoExistente e) {
			try {
				reuniao.adicionarParticipante(dataReuniao, numAssociacao, codigoAssociado);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public double calcularFrequencia(int numAssociado, int numAssociacao, long inicio, long fim)
			throws AssociadoNaoExistente, AssociacaoNaoExistente {
		Associacao associacao = verificaAssociacao(numAssociacao);

		associacao.pesquisaAssociado(numAssociado);

		double reunioesParticipadas = 0.0;

		ArrayList<Reuniao> reunioesOcorridas = new ArrayList<Reuniao>();
		try {
			reunioesOcorridas = associacao.pesquisaReunioes(inicio, fim);
		} catch (ReuniaoNaoExistente e) {
			System.out.println("Error");
		}

		for (Reuniao reuniaoAtual : reunioesOcorridas) {
			try {
				reuniaoAtual.pesquisaFrequencia(numAssociado, reuniaoAtual.getData());
				reunioesParticipadas++;
			} catch (AssociadoNaoExistente e) {
				// Não há associado nessa reunião logo não precisa fazer nada
			}
		}
		return reunioesParticipadas / reunioesOcorridas.size();
	}

	@Override
	public void registrarPagamento(int numAssociacao, String taxa, int vigencia, int numAssociado, long data,
			double valor)
			throws AssociacaoNaoExistente, AssociadoNaoExistente, AssociadoJaRemido, TaxaNaoExistente, ValorInvalido {
		if (valor <= 0) {
			throw new ValorInvalido();
		}

		Associacao associacao = verificaAssociacao(numAssociacao);

		Associado associado = associacao.pesquisaAssociado(numAssociado);

		Taxa taxaDesejada = associacao.pesquisaTaxa(taxa, vigencia);

		try {
			taxaDesejada.pagamento(data, valor, associado);
		} catch (SQLException e) {
			System.out.println("Erro");
		}

	}

	@Override
	public double somarPagamentoDeAssociado(int numAssociacao, int numAssociado, String nomeTaxa, int vigencia,
			long inicio, long fim) throws AssociacaoNaoExistente, AssociadoNaoExistente, TaxaNaoExistente {
		Associacao associacao = verificaAssociacao(numAssociacao);

		Associado associado = associacao.pesquisaAssociado(numAssociado);

		Taxa taxaDesejada = associacao.pesquisaTaxa(nomeTaxa, vigencia);

		double valorPagamentos = 0.0;
		try {
			for (LogPagamento logAtual : taxaDesejada.getLogPagamentos()) {
				if (logAtual.getAssociado().getNumero() == associado.getNumero() && logAtual.getData() >= inicio
						&& logAtual.getData() <= fim) {
					valorPagamentos += logAtual.getValor();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return valorPagamentos;
	}

	@Override
	public double calcularTotalDeTaxas(int numAssociacao, int vigencia) throws AssociacaoNaoExistente {
		Associacao associacao = verificaAssociacao(numAssociacao);

		ArrayList<Taxa> taxasDesejadas = new ArrayList<Taxa>();
		try {
			taxasDesejadas = associacao.pesquisaTaxas(vigencia);
		} catch (TaxaNaoExistente e) {
			return 0;
		}

		double totalTaxasPrevistas = 0.0;
		for (Taxa taxaAtual : taxasDesejadas) {
			totalTaxasPrevistas += taxaAtual.getValorAno();
		}

		return totalTaxasPrevistas;
	}

	public void limparBanco() {
		DAOAssociado daoAssociado = new DAOAssociado();
		DAOAssociacao daoAssociacao = new DAOAssociacao();
		DAOFrequencia daoFrequencia = new DAOFrequencia();
		DAOPagamento daoPagamento = new DAOPagamento();
		DAOReuniao daoReuniao = new DAOReuniao();
		DAOTaxa daoTaxa = new DAOTaxa();
		
		try {
			daoAssociado.removerTodos();
			daoAssociacao.removerTodos();
			daoFrequencia.removerTodos();
			daoPagamento.removerTodos();
			daoReuniao.removerTodos();
			daoTaxa.removerTodos();
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}
}
