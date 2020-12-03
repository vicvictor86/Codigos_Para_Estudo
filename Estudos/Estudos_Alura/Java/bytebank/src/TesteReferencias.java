
public class TesteReferencias {

	public static void main(String[] args) {
		
		Conta primeiraConta = new Conta();
		primeiraConta.saldo = 300;
		
		System.out.println("Saldo da primeira: " + primeiraConta.saldo );
		Conta segundaConta = primeiraConta;
		System.out.println("Saldo da segunda: " + segundaConta.saldo);
		
		primeiraConta.saldo = 500;
		
		System.out.println("Saldo da primeira/2 " + primeiraConta.saldo);
		System.out.println("Saldo da segunda/2 " + segundaConta.saldo);
		
		System.out.println("A referência da primeira conta é" + primeiraConta);
		System.out.println("A referência da segunda conta é" +  segundaConta);
	}
	
}
