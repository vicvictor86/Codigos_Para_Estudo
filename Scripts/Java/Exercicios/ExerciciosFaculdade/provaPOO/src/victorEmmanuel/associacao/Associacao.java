package victorEmmanuel.associacao;

import java.util.ArrayList;

public class Associacao {

    private int num;
    private String nome;
    private ArrayList<Associado> associados = new ArrayList<Associado>();
    private ArrayList<Reuniao> reunioes = new ArrayList<Reuniao>();
    private ArrayList<Taxa> taxasAssociados = new ArrayList<Taxa>();

    public Associacao(int num, String nome){
        this.num = num;
        this.nome = nome;
    }

    public int getNum() {
        return num;
    }

    public String getNome() {
        return nome;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Associado pesquisaAssociado(int codigoAssociado) throws AssociadoNaoExistente {
        for (Associado associadoAtual : associados) {
            if(associadoAtual.getNumero() == codigoAssociado){
                return associadoAtual;
            }
        }
        throw new AssociadoNaoExistente();
    }

    public Reuniao pesquisaReuniao(long dataReuniao) throws ReuniaoNaoExistente {
        for (Reuniao reuniaoAtual : reunioes) {
            if(reuniaoAtual.getData() == dataReuniao){
                return reuniaoAtual;
            }
        }
        throw new ReuniaoNaoExistente();
    }

    public ArrayList<Reuniao> pesquisaReunioes(long dataInicio, long dataFinal) throws ReuniaoNaoExistente {
        ArrayList<Reuniao> reunioesAtuais = new ArrayList<Reuniao>();
        for (Reuniao reuniaoAtual : reunioes) {
            if(reuniaoAtual.getData() >= dataInicio && reuniaoAtual.getData() <= dataFinal){
                reunioesAtuais.add(reuniaoAtual);
            }
        }
        if(reunioesAtuais.isEmpty()){
            throw new ReuniaoNaoExistente();
        }
        return reunioesAtuais;
    }

    public Taxa pesquisaTaxa(String nome, int vigencia) throws TaxaNaoExistente {
        for (Taxa taxaAtual : taxasAssociados) {
            if(taxaAtual.getNome().equals(nome) && taxaAtual.getVigencia() == vigencia){
                return taxaAtual;
            }
        }
        throw new TaxaNaoExistente();
    }

    public ArrayList<Taxa> pesquisaTaxas(int vigencia) throws TaxaNaoExistente {
        ArrayList<Taxa> taxaAtuais = new ArrayList<Taxa>();
        for (Taxa taxaAtual : taxasAssociados) {
            if(taxaAtual.getVigencia() == vigencia){
                taxaAtuais.add(taxaAtual);
            }
        }
        if(taxaAtuais.isEmpty()){
            throw new TaxaNaoExistente();
        }
        return taxaAtuais;
    }

    public void adicionarAssociado(Associado a){
        associados.add(a);
    }

    public void adicionarReuniao(Reuniao r){
        reunioes.add(r);
    }

    public void adicionarTaxa(Taxa t){
        taxasAssociados.add(t);
    }
}
