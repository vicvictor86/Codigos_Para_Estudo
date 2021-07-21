package victorEmmanuel.associacaoBD;

public class LogPagamento {

    private long data;
    private double valor;
    private int vigencia;
    private Taxa taxa;
    private Associado associado;

    public LogPagamento(long data, double valor, Associado associado, Taxa taxa, int vigencia) {
        this.data = data;
        this.valor = valor;
        this.associado = associado;
        this.taxa = taxa;
        this.vigencia = vigencia;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }
    
    

    public int getVigencia() {
		return vigencia;
	}

	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}

	public Taxa getTaxa() {
		return taxa;
	}

	public void setTaxa(Taxa taxa) {
		this.taxa = taxa;
	}

	public void setValor(double valor) {
        this.valor = valor;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }
}
