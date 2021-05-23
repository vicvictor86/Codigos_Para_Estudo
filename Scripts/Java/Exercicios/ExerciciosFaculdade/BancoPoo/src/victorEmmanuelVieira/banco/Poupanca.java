package victorEmmanuelVieira.banco;

public class Poupanca extends ContaComum {

	public Poupanca(int n) {
		super(n);
	}

	public void renderJuros(Conta c, double taxa) {
		credito(getSaldo() * taxa);
	}
}