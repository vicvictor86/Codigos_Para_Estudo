
public class TesteFuncionario {
	
	public static void main(String[] args) {
		
		Gerente nico = new Gerente();
		nico.setNome("Nico");
		nico.setCpf("12312-9");
		nico.setSalario(2600.00);
		
		System.out.println(nico.getBonificacao());
		System.out.println(nico.getNome());
		
	}
	
	
}
