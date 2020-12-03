
public class CriaConta {
	
	public static void main(String[] args) {
		
		Conta primeiraConta = new Conta();
		primeiraConta.saldo = 200;
		System.out.println("Saldo da primeira conta: " + primeiraConta.saldo);
		
		Conta segundaConta = new Conta();
		segundaConta.saldo = 300;
		System.out.println("Saldo da segunda conta: " + segundaConta.saldo);
		
		System.out.println("A referência da primeira conta é " + primeiraConta);
		System.out.println("A referência da segunda conta é " + segundaConta);
		 
	}

}
