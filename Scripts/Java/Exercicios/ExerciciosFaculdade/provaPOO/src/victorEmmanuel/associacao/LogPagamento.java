package victorEmmanuel.associacao;

public class LogPagamento {

    private long data;
    private double valor;
    private Associado associado;

    public LogPagamento(long data, double valor, Associado associado) {
        this.data = data;
        this.valor = valor;
        this.associado = associado;
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
