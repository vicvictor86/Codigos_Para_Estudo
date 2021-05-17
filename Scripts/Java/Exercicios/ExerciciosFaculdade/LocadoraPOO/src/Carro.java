import java.util.Date;

public class Carro extends Veiculos{

    private int categoria;

    public Carro(int categoria) {
        this.categoria = categoria;
    }

    public Carro(String marca, String modelo, Date anoDeFabricacao, String placa, double valorDiaria, double valorDeBem, double porcentagem, int categoria) {
        super(marca, modelo, anoDeFabricacao, placa, valorDiaria, valorDeBem, 0.03);
        this.categoria = categoria;
    }

    public String getCategoria(){
        switch (categoria){
            case 1:
                return "Passeio";
            case 2:
                return "SUV";
            case 3:
                return "Pickup";
            default:
                return "Categoria inválida";
        }
    }
}
