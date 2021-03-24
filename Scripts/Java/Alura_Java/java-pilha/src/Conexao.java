
public class Conexao implements AutoCloseable{

	public Conexao() {
		System.out.println("Abrindo conex�o");
	}
	
	public void lerDados() {
		System.out.println("Recebendo dados");
		throw new IllegalStateException();
	}

	@Override
	public void close() {
		System.out.println("Fechando conexao");
		
	}
	
	
}
