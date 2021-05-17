import java.util.ArrayList;

public class Locadora {

    public ArrayList<Veiculos> repositorioDeVeiculos;

    public void inserir(Veiculos veiculo){
        Veiculos jaExiste = procurar(veiculo.getPlaca());
        if(jaExiste != null){
            System.out.println("Veículo já existente");
            return;
        }

        repositorioDeVeiculos.add(veiculo);
    }

    public Veiculos procurar(String placa){
        for (Veiculos veiculoLista : repositorioDeVeiculos) {
            if(veiculoLista.getPlaca().equals(placa)){
                return veiculoLista;
            }
        }
        return null;
    }

    public void cadastrarVeiculo(Veiculos veiculo){

    }

    public void consultarAluguel(Veiculos veiculo){

    }

    public void consultarSeguro(Veiculos veiculo){

    }

    public void aumentarDiaria(int tipo, double taxaDeAumento){

    }

    public void DiminuirDiaria(int tipo, double taxaDeDepreciacao){

    }

    public void aumentarValor(int tipo, double taxaDeAumento){

    }

    public void DiminuirValor(int tipo, double taxaDeDepreciacao){

    }

    public void consultarFrota(){

    }

}
