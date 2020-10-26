import java.util.Scanner;

public class TestaInformacao {
    
    public static void main(String[] args) {
        Scanner teclado =  new Scanner(System.in);
        while(true){

            while(true){
                System.out.println("Digite seu nome: ");
                String nome = teclado.nextLine();
                if(nome.length() > 3){
                    System.out.println("Nome válido");
                    System.out.println(nome);
                    break;
                }
                System.out.println("Nome inválido, digite novamente");
                    
            }

            while(true){
                System.out.println("Digite sua idade: ");
                Integer idade = teclado.nextInt();
                if(0 < idade && idade < 150){
                    System.out.println("Idade válida");
                    System.out.println(idade);
                    break;
                }
                System.out.println("Idade inválida, digite novamente");
                    
            }

            while(true){
                System.out.println("Digite seu salário: ");
                Double salario = teclado.nextDouble();
                if(salario > 0){
                    System.out.println("Salário válido");
                    System.out.println(salario);
                    break;
                }
                System.out.println("Salário inválido, digite novamente");
                    
            }

            while(true){
                System.out.println("Digite seu sexo: ");
                String sexo = teclado.nextLine();
                if(sexo.contentEquals("f") || sexo.contentEquals("m") ) {
                    System.out.println("Sexo válido");
                    System.out.println(sexo);
                    break;
                }
                System.out.println("Sexo inválido, digite novamente");
                    
            }

            while(true){
                System.out.println("Digite seu Estado Civil: ");
                String estadoCivil = teclado.nextLine();
                if(estadoCivil.contentEquals("s") || estadoCivil.contentEquals("c") || estadoCivil.contentEquals("v") || estadoCivil.contentEquals("d") ) {
                    System.out.println("Estado civil válido");
                    System.out.println(estadoCivil);
                    break;
                }
                System.out.println("Estado civil inválido, digite novamente");
                    
                

            }
            
            teclado.close();
            break;
        }

    }

}