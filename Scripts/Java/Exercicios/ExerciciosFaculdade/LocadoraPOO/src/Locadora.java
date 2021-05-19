import java.util.ArrayList;

public class Locadora {

    private double faturamentoMoto;
    private double faturamentoCarro;
    private double faturamentoOnibus;
    private double faturamentoCaminhao;

    public ArrayList<Veiculo> repositorioDeVeiculos = new ArrayList<Veiculo>();
    public ArrayList<Cliente> repositorioDeCliente = new ArrayList<Cliente>();

    public void inserir(Veiculo veiculo){
        Veiculo jaExiste = pesquisar(veiculo.getPlaca());
        if(jaExiste != null){
            System.out.println("Veículo já existente");
            return;
        }

        repositorioDeVeiculos.add(veiculo);
    }

    public void inserir(Cliente cliente){
        Cliente jaExiste = pesquisarCliente(cliente.getCpf());
        if(jaExiste != null){
            System.out.println("Cliente já existente");
            return;
        }

        repositorioDeCliente.add(cliente);
    }

    public Veiculo pesquisar(String placa){
        for (Veiculo veiculoLista : repositorioDeVeiculos) {
            if(veiculoLista.getPlaca().equals(placa)){
                return veiculoLista;
            }
        }
        return null;
    }

    public Cliente pesquisarCliente(String cpf){
        for (Cliente cliente :
                repositorioDeCliente) {
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }

    public ArrayList<Veiculo> pesquisarMoto(int cilindrada){

        ArrayList<Veiculo> motos = new ArrayList<Veiculo>();
        for (Veiculo veiculoLista : repositorioDeVeiculos) {
            if(veiculoLista instanceof Moto && cilindrada == ((Moto) veiculoLista).getCilindradas()){
                motos.add(veiculoLista);
            }
        }

        return motos;
    }

    public ArrayList<Veiculo> pesquisarCarro(int tipoCarro){

        ArrayList<Veiculo> carros = new ArrayList<Veiculo>();
        for (Veiculo veiculoLista : repositorioDeVeiculos) {
            if(veiculoLista instanceof Carro && tipoCarro == ((Carro) veiculoLista).getCategoria()){
                carros.add(veiculoLista);
            }
        }

        return carros;
    }

    public ArrayList<Veiculo> pesquisarCaminhao(int carga){

        ArrayList<Veiculo> caminhoes = new ArrayList<Veiculo>();
        for (Veiculo veiculoLista : repositorioDeVeiculos) {
            if(veiculoLista instanceof Caminhao && carga == ((Caminhao) veiculoLista).getCapacidadeDeCarga()){
                caminhoes.add(veiculoLista);
            }
        }

        return caminhoes;
    }

    public ArrayList<Veiculo> pesquisarOnibus(int passageiros){

        ArrayList<Veiculo> onibus = new ArrayList<Veiculo>();
        for (Veiculo veiculoLista : repositorioDeVeiculos) {
            if(veiculoLista instanceof Onibus && passageiros == ((Onibus) veiculoLista).getPassageiros()){
                onibus.add(veiculoLista);
            }
        }

        return onibus;
    }

    public double calcularAluguel(String placa, int dias){
        Veiculo atual = pesquisar(placa);
        return atual.aluguel(dias);
    }

    public void registrarAluguel(String placa, int dias, Cliente cliente){
        double precoAluguel = calcularAluguel(placa, dias);

        Veiculo atual = pesquisar(placa);
        if(atual.isAlugado()){
            System.out.println("Veículo já alugado");
        }else{
            atual.setClienteAlugou(cliente);
            cliente.setPrecoAluguel(precoAluguel);

            atual.alugar();
            System.out.println("Veículo alugado com sucesso");
        }
    }

    private void devolucao(Cliente cliente, Veiculo atual){
        cliente.setPrecoAluguel(0.0);
        atual.devolver();
    }

    private void registrarEspecifico(Cliente cliente, Veiculo atual){
        if(atual instanceof Moto){
            faturamentoMoto += cliente.getPrecoAluguel();
            devolucao(cliente, atual);
        }else if(atual instanceof  Carro){
            faturamentoCarro += cliente.getPrecoAluguel();
            devolucao(cliente, atual);
        }else if(atual instanceof  Onibus){
            faturamentoOnibus += cliente.getPrecoAluguel();
            devolucao(cliente, atual);
        }else if(atual instanceof  Caminhao){
            faturamentoCaminhao += cliente.getPrecoAluguel();
            devolucao(cliente, atual);
        }
    }

    public void registrarDevolucao(String placa, Cliente cliente){
        Veiculo atual = pesquisar(placa);
        if(atual.isAlugado() && atual.getClienteAlugou().getCpf().equals(cliente.getCpf())){
            registrarEspecifico(cliente, atual);
        }
    }

    private void depreciarEspecifico(Class tipoVeiculo, double taxaDeDepreciacao){
        for (Veiculo veiculoLista : repositorioDeVeiculos) {
            if(tipoVeiculo.isInstance(veiculoLista)){
                veiculoLista.depreciarVeiculo(taxaDeDepreciacao);
            }
        }
    }

    public void depreciarVeiculos(int tipo, double taxaDeDepreciacao){
        switch (tipo){
            case 0:
                depreciarEspecifico(Veiculo.class, taxaDeDepreciacao);
                break;
            case 1:
                depreciarEspecifico(Moto.class, taxaDeDepreciacao);
                break;
            case 2:
                depreciarEspecifico(Carro.class, taxaDeDepreciacao);
                break;
            case 3:
                depreciarEspecifico(Onibus.class, taxaDeDepreciacao);
                break;
            case 4:
                depreciarEspecifico(Caminhao.class, taxaDeDepreciacao);
                break;
            default:
                break;
        }
    }

    private void aumentarEspecifico(Class tipoVeiculo, double taxaAumento){
        for (Veiculo veiculoLista : repositorioDeVeiculos) {
            if(tipoVeiculo.isInstance(veiculoLista)){
                veiculoLista.apreciarVeiculo(taxaAumento);
            }
        }
    }

    public void aumentarDiaria(int tipo, double taxaAumento){
        switch (tipo){
            case 0:
                aumentarEspecifico(Veiculo.class, taxaAumento);
                break;
            case 1:
                aumentarEspecifico(Moto.class, taxaAumento);
                break;
            case 2:
                aumentarEspecifico(Carro.class, taxaAumento);
                break;
            case 3:
                aumentarEspecifico(Onibus.class, taxaAumento);
                break;
            case 4:
                aumentarEspecifico(Caminhao.class, taxaAumento);
                break;
            default:
                break;
        }
    }

    public double faturamentoTotal(int tipo){

        switch (tipo){
            case 0:
                return (faturamentoCaminhao + faturamentoMoto + faturamentoOnibus + faturamentoCarro);
            case 1:
                return (faturamentoMoto);
            case 2:
                return (faturamentoCarro);
            case 3:
                return (faturamentoOnibus);
            case 4:
                return (faturamentoCaminhao);
            default:
                return 0;
        }
    }

    private int quantidadeDeCadaVeiculo(Class tipoVeiculo){
        int quantidadeDeDiarias = 0;
        for (Veiculo veiculoLista : repositorioDeVeiculos) {
            if(tipoVeiculo.isInstance(veiculoLista)){
                quantidadeDeDiarias += veiculoLista.getQuantidadeAlugueisFechados();
            }
        }

        return  quantidadeDeDiarias;
    }

    public int quantidadeTotalDeDiarias(int tipo){
        switch (tipo){
            case 0:
                return quantidadeDeCadaVeiculo(Veiculo.class);
            case 1:
                return quantidadeDeCadaVeiculo(Moto.class);
            case 2:
                return quantidadeDeCadaVeiculo(Carro.class);
            case 3:
                return quantidadeDeCadaVeiculo(Onibus.class);
            case 4:
                return quantidadeDeCadaVeiculo(Caminhao.class);
            default:
                return 0;
        }
    }
}
