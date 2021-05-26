public class Carro extends Veiculo {

    private int categoria;

    public Carro(int categoria) {
        this.categoria = categoria;
    }

    public Carro(String marca, String modelo, int anoDeFabricacao, String placa, double valorDiaria, double valorDeBem, int categoria) {
        super(marca, modelo, anoDeFabricacao, placa, valorDiaria, valorDeBem, 0.03);
        this.categoria = categoria;
    }

    public int getCategoria(){
        return this.categoria;
    }
}
