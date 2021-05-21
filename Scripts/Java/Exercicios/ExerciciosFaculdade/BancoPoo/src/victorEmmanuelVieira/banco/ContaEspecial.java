package victorEmmanuelVieira.banco;

public class ContaEspecial extends Conta {

	private double limite;
	

	
	public ContaEspecial(int n, double l) {
		super(n);
		limite = l;
	}

	public void debito(double val) throws SaldoInsuficiente {
		if (val <= saldo + limite) {
		  saldo = saldo - val;
		  extrato = extrato + " Débito: " + val +
				". Saldo: " + getSaldo() + ".\n";
		} else {
			throw new SaldoInsuficiente(getNum(), getSaldo());
		}
	}

}
