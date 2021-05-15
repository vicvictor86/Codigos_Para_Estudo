package victorEmmanuelVieira.banco;

public class Banco {

	private Conta[] contas;
	private int indice = 0;

	public Banco() {
		contas = new Conta[50];
	}

	void incluir(Conta c) {
		if (indice < 50) {
			contas[indice++] = c;
		} else {
			System.out.println("Falha na inclusão da conta");
		}
	}

	private Conta procuraConta(int num) {
		for (int i = 0; i < indice; i++) {
			if (contas[i].getNum() == num) {
				return contas[i];
			}
		}
		return null;
	}

	public void deposito(int num, double val) {
		Conta conta = procuraConta(num);
		if (conta != null) {
			conta.credito(val);
		}
	}

	public void saque(int num, double val) {
		Conta conta = procuraConta(num);
		if (conta != null) {
			conta.debito(val);
		}
	}

	public double saldo(int num) {
		Conta conta = procuraConta(num);
		if (conta != null) {
			return conta.getSaldo();
		}
		return -999999;
	}

	public void renderJuros(int num){
		Conta conta = procuraConta(num);
		if(conta != null && conta instanceof Poupanca){
			((Poupanca) conta).renderJuros(num);
		}
	}

	public void transfere(int paga, int recebe, double valor) {
		Conta contaPaga = procuraConta(paga);
		Conta contaRecebe = procuraConta(recebe);

		if (contaPaga != null && contaRecebe != null) {
			double valorRetirado = contaPaga.debito(valor);
			contaRecebe.credito(valorRetirado);
			System.out.println("A conta " + contaPaga.getNum() + " transferiu: " + valorRetirado
					+ " reais para a conta " + contaRecebe.getNum());
		} else {
			System.out.println("A transferência não teve sucesso");
		}

	}

	public String extrato(int num) {
		Conta contaExtrato = procuraConta(num);
		if (contaExtrato != null) {
			return contaExtrato.getExtrato();
		} else {
			return "";
		}
	}
}
