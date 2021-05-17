import java.util.Date;

public class Onibus extends Veiculos{
    private int passageiros;

    public Onibus(int passageiros) {
        this.passageiros = passageiros;
    }

    public Onibus(String marca, String modelo, Date anoDeFabricacao, String placa, double valorDiaria, double valorDeBem, double porcentagem, int passageiros) {
        super(marca, modelo, anoDeFabricacao, placa, valorDiaria, valorDeBem, 0.20);
        this.passageiros = passageiros;
    }

    public int getPassageiros() {
        return passageiros;
    }
}
