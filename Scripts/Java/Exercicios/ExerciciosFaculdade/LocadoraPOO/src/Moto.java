
public class Moto extends Veiculo {

    private int cilindradas;

    public Moto(int cilindradas){
        this.cilindradas = cilindradas;
    }

    public Moto(String marca, String modelo, int anoDeFabricacao, String placa, double valorDiaria, double valorDeBem, int cilindradas) {
        super(marca, modelo, anoDeFabricacao, placa, valorDiaria, valorDeBem, 0.11);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

}
