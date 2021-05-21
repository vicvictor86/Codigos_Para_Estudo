package victorEmmanuelVieira.banco;

public interface EstruturaDeDadosDeContas {

	public Conta pesquisar(int n) throws ContaInexistente;
	
	public void incluir(Conta c);
}
