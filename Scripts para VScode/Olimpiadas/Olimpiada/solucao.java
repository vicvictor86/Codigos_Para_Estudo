import java.util.Scanner;

public class solucao {
    
    public static void main(String[] args) {
        
        String p;
        Scanner in = new Scanner(System.in);
        int letrasIguais = 0;
        String A; 
        int quantidadeAsteriscos = 0;

        p = in.nextLine();
        A = in.nextLine();

        for(int i = 0; i < A.length(); i++){
            Character letraSegunda = A.charAt(i);
            if(letraSegunda == '*'){
                quantidadeAsteriscos += 1;
            }
            else{
                for(int j = 0; j < p.length(); j++){
                    if(letraSegunda.equals(p.charAt(j))){
                        letrasIguais += 1;
                        break;
                    }
                }
            }
        }
        if(letrasIguais == p.length() - quantidadeAsteriscos){
            System.out.printf("%s\n", "S");
        }
        else{
            System.out.printf("%s\n", "N");
        }

    }

}
