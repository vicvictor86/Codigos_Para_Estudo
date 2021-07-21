package victorEmmanuel.associacaoBD;

import java.sql.SQLException;

public class Associado {
    private int numero;
    private String nome;
    private String telefone;
    private long dataAssociacao;
    private long nascimento;
    private Associacao associacao;

    public Associado(int numero, String nome, String telefone, long dataAssociacao, long nascimento) {
        this.numero = numero;
        this.nome = nome;
        this.telefone = telefone;
        this.dataAssociacao = dataAssociacao;
        this.nascimento = nascimento;
    }
    
    public Associado(int numero, String nome, String telefone, long dataAssociacao, long nascimento, Associacao associacao) throws SQLException {
        this.numero = numero;
        this.nome = nome;
        this.telefone = telefone;
        this.dataAssociacao = dataAssociacao;
        this.nascimento = nascimento;
        DAOAssociacao daoAssociacao = new DAOAssociacao();      	
        this.associacao = associacao;
        
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public long getDataAssociacao() {
        return dataAssociacao;
    }

    public long getNascimento() {
        return nascimento;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataAssociacao(long dataAssociacao) {
        this.dataAssociacao = dataAssociacao;
    }

    public void setNascimento(long nascimento) {
        this.nascimento = nascimento;
    }

	public Associacao getAssociacao() {
		return associacao;
	}

	public void setAssociacao(Associacao associacao) {
		this.associacao = associacao;
	}
}
