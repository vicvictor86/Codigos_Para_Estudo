package victorEmmanuelVieira.banco;

public class Banco {
	
	private EstruturaDeDadosDeContas contas = new VetorDeContas();
	
	public void incluir(Conta c) {
		contas.incluir(c);
	}
	
	private Conta pesquisar(int n) throws ContaInexistente {
		return contas.pesquisar(n);
	}
	
	public void saque(int n, double v) throws SaldoInsuficiente, ContaInexistente {
		Conta c = pesquisar(n);
		c.debito(v);
	}
	
	public void deposito(int n, double v) throws ContaInexistente {
		Conta c = pesquisar(n);
		c.credito(v);
	}
	
	public void rendeJuros(int n, double t) throws ContaInexistente, NaoEhPoupanca {
		Conta c = pesquisar(n);
		if(c instanceof Poupanca) {			
			((Poupanca) c).renderJuros(c, t);
		}else{
			throw new NaoEhPoupanca(c.getNum());
		}
	}	
	
	public double saldo(int n) throws ContaInexistente {
		Conta c = pesquisar(n);
		return c.getSaldo();
	}
	
	public String extrato(int n) throws ContaInexistente {
		Conta c = pesquisar(n);
		return c.getExtrato();
	}
}
