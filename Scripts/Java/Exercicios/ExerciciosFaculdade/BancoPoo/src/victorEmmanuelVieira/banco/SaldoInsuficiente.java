package victorEmmanuelVieira.banco;

public class SaldoInsuficiente extends Exception {

	public SaldoInsuficiente(int n, double s) {
		super("A conta de número " + n + 
				" não possui saldo para a operação. "
				+ "Saldo atual: " + s);
	}
}
