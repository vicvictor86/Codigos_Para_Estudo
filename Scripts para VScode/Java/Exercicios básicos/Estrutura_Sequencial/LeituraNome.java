import java.util.Scanner;

public class LeituraNome {
    
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite seu usuário: ");
        String user = teclado.nextLine();
        while(true){

            

            System.out.println("Digite sua senha: ");
            String password = teclado.nextLine();

            if(!user.contentEquals(password)){
    
                System.out.println("Senha correta");
                break;
    
            }
            else{
                System.out.println("Senha incorreta tente novamente");
            }

        }
        
        teclado.close();
    }


}