package victorEmmanuelVieira.banco;

public class ContaComum extends Conta {

	public ContaComum(int n) {
		super(n);
	}

	public void debito(double val) throws SaldoInsuficiente {
		if (val <= saldo) {
		  saldo = saldo - val;
		  extrato = extrato + " Débito: " + val +
				". Saldo: " + getSaldo() + ".\n";
		} else {
			throw new SaldoInsuficiente(getNum(), getSaldo());
		}
	}
}
