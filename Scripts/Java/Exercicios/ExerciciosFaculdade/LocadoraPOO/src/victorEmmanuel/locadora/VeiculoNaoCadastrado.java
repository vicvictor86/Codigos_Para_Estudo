package victorEmmanuel.locadora;

public class VeiculoNaoCadastrado extends Exception {
	public VeiculoNaoCadastrado() {
		super("Veiculo não cadastrado");
	}
}
