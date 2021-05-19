import java.util.Date;

public class Caminhao extends Veiculo {

    int capacidadeDeCarga;

    public Caminhao(int capacidadeDeCarga) {
        this.capacidadeDeCarga = capacidadeDeCarga;
    }

    public Caminhao(String marca, String modelo, Date anoDeFabricacao, String placa, double valorDiaria, double valorDeBem, int capacidadeDeCarga) {
        super(marca, modelo, anoDeFabricacao, placa, valorDiaria, valorDeBem, 0.08);
        this.capacidadeDeCarga = capacidadeDeCarga;
    }

    public double getCapacidadeDeCarga() {
        return capacidadeDeCarga;
    }
}
