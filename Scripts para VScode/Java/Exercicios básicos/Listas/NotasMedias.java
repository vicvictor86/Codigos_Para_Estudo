import java.util.ArrayList;

public class NotasMedias {
    
    public static void main(String[] args) {
        
        Double total = 0.0;
        ArrayList<Double> notas = new ArrayList<Double>();
        notas.add(8.5);
        notas.add(7.2);
        notas.add(5.4);
        notas.add(9.6);
        for(int i = 0; i < 4; i++){
            
            System.out.println("A nota " + (i+1) + " foi : " + notas.get(i));
            total += notas.get(i);

        }

        System.out.printf("E a média foi: %.2f ", total / 4);

    }

}