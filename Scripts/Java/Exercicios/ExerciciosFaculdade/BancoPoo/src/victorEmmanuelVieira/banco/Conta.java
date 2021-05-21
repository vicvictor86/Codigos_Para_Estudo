package victorEmmanuelVieira.banco;

public abstract class Conta {
	
    private int num;
    protected double saldo;
    protected String extrato = "";
    private PessoaFisica titular;
	
	public PessoaFisica getTitular() {
		return titular;
	}

	public void setTitular(PessoaFisica titular) {
		this.titular = titular;
	}

	public String getExtrato() {
		return extrato;
	}

	public int getNum() {
		return num;
	}

	public double getSaldo() {
		return saldo;
	}

	public void credito(double val) {
		saldo = saldo + val;
		extrato = extrato + " Crédito: " + val +
				". Saldo: " + getSaldo() + ".\n";
	}
 
	public abstract void debito(double val) throws SaldoInsuficiente;
	
	public Conta(int n) {
		num = n;
	}
}
