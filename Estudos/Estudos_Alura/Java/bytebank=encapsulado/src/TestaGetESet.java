
public class TestaGetESet {

	public static void main(String[] args) {
		
		Conta contaDiana = new Conta(1337, 24226);
		Cliente diana = new Cliente();
		//Liga��o entre contaDiana e diana
		contaDiana.setTitular(diana);

		//Setagem do nome - cliente
		contaDiana.getTitular().setNome("Diana");
		System.out.println(contaDiana.getTitular().getNome());
		
		//Setagem do numero - conta que n�o � mais necess�rio pois foi setado no Construtor
		//contaDiana.setNumero(1337);
		//System.out.println(contaDiana.getNumero());
		
		//setagem do cpf - cliente
		contaDiana.getTitular().setCpf("123");
		System.out.println(contaDiana.getTitular().getCpf());
		
		//setagem da profiss�o - cliente
		contaDiana.getTitular().setProfiss�o("Programador");
		System.out.println(contaDiana.getTitular().getProfiss�o());
	}
	
	
}
