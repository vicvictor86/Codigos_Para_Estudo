package victorEmmanuel.associacaoBD;

import java.sql.SQLException;
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

    public ArrayList<Taxa> getTaxasAssociados() throws SQLException {
        if(taxasAssociados.isEmpty()){
            DAOTaxa daoTaxa = new DAOTaxa();
            taxasAssociados = daoTaxa.recuperar(this);
        }
        return taxasAssociados;
    }

    public ArrayList<Associado> getAssociados() throws SQLException{
    	if(associados.isEmpty()) {
    		DAOAssociado daoAssociado = new DAOAssociado();
    		associados = daoAssociado.recuperar(this);
    	}
    	return associados;
    }

    public ArrayList<Reuniao> getReunioes() throws SQLException{
        if(reunioes.isEmpty()) {
            DAOReuniao daoReuniao = new DAOReuniao();
            reunioes = daoReuniao.recuperar(this.getNum());
        }
        return reunioes;
    }
    
    public Associado pesquisaAssociado(int codigoAssociado) throws AssociadoNaoExistente {
        try {
			for (Associado associadoAtual : getAssociados()) {
			    if(associadoAtual.getNumero() == codigoAssociado){
			        return associadoAtual;
			    }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        throw new AssociadoNaoExistente();
    }

    public Reuniao pesquisaReuniao(long dataReuniao) throws ReuniaoNaoExistente {
        try {
            for (Reuniao reuniaoAtual : getReunioes()) {
                if(reuniaoAtual.getData() == dataReuniao){
                    return reuniaoAtual;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new ReuniaoNaoExistente();
    }

    public ArrayList<Reuniao> pesquisaReunioes(long dataInicio, long dataFinal) throws ReuniaoNaoExistente {
        ArrayList<Reuniao> reunioesAtuais = new ArrayList<Reuniao>();
        try {
            for (Reuniao reuniaoAtual : getReunioes()) {
                if(reuniaoAtual.getData() >= dataInicio && reuniaoAtual.getData() <= dataFinal){
                    reunioesAtuais.add(reuniaoAtual);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(reunioesAtuais.isEmpty()){
            throw new ReuniaoNaoExistente();
        }
        return reunioesAtuais;
    }

    public Taxa pesquisaTaxa(String nome, int vigencia) throws TaxaNaoExistente {
        try {
			for (Taxa taxaAtual : getTaxasAssociados()) {
			    if(taxaAtual.getNome().equals(nome) && taxaAtual.getVigencia() == vigencia){
			        return taxaAtual;
			    }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        throw new TaxaNaoExistente();
    }

    public ArrayList<Taxa> pesquisaTaxas(int vigencia) throws TaxaNaoExistente {
        ArrayList<Taxa> taxaAtuais = new ArrayList<Taxa>();
        try {
            for (Taxa taxaAtual : getTaxasAssociados()) {
                if(taxaAtual.getVigencia() == vigencia){
                    taxaAtuais.add(taxaAtual);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(taxaAtuais.isEmpty()){
            throw new TaxaNaoExistente();
        }
        return taxaAtuais;
    }

    public void adicionarAssociado(Associado a){
        associados.add(a);
    }
    
    public void adicionarReuniao(Reuniao r, int associacao) throws SQLException {
        DAOReuniao daoReuniao = new DAOReuniao();
        daoReuniao.inserir(r, associacao);
    }

    public void adicionarTaxa(Taxa t){
        taxasAssociados.add(t);
    }
}
