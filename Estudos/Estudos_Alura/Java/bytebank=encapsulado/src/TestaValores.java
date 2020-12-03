
public class TestaValores {

	public static void main(String[] args) {
		
		Conta conta = new Conta(12);
		System.out.println(conta.getAgencia());
		System.out.println(conta.getNumero());
		
		Conta conta2 = new Conta(12,355);
		Conta conta3 = new Conta(12,355);
		
		System.out.println("O total de contas é " + Conta.getTotal());
		
		
	}
	
	
}
