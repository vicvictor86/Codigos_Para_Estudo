package victorEmmanuelVieira.banco;

public class Poupanca extends ContaComum {

	public Poupanca(int n) {
		super(n);
	}

	public void renderJuros(double taxa) {
		credito(getSaldo() * taxa);
	}
}