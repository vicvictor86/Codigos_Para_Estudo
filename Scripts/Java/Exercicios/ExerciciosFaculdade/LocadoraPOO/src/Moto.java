import java.util.Date;

public class Moto extends Veiculos{

    private int cilindradas;

    public Moto(int cilindradas){
        this.cilindradas = cilindradas;
    }

    public Moto(String marca, String modelo, Date anoDeFabricacao, String placa, double valorDiaria, double valorDeBem, int cilindradas) {
        super(marca, modelo, anoDeFabricacao, placa, valorDiaria, valorDeBem, 0.11);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

}
