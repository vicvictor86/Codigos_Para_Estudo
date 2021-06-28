package victorEmmanuel.locadora;

public class ClienteJaCadastrado extends Exception {
	
	public ClienteJaCadastrado(){
		super("Cliente já cadastrado");
	}
}
