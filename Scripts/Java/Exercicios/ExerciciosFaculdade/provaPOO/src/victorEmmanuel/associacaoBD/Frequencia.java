package victorEmmanuel.associacaoBD;

public class Frequencia {
	private long data;
	private int associacao;
	private int associado;
	
	public Frequencia(long data, int associacao, int associado) {
		this.data = data;
		this.associacao = associacao;
		this.associado = associado;
	}
	
	public long getData() {
		return data;
	}
	public void setData(long data) {
		this.data = data;
	}
	public int getAssociacao() {
		return associacao;
	}
	public void setAssociacao(int associacao) {
		this.associacao = associacao;
	}
	public int getAssociado() {
		return associado;
	}
	public void setAssociado(int associado) {
		this.associado = associado;
	}
	
	
}
