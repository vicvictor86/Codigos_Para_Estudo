import java.util.Date;

public abstract class Veiculo {

    private String marca;
    private String modelo;
    private Date anoDeFabricacao;
    private String placa;
    private double valorDiaria;
    private double valorDeBem;
    private double porcentagem;
    private boolean alugado;
    private int quantidadeAlugueisFechados;
    private Cliente clienteAlugou;

    public Veiculo(){

    }

    public Veiculo(String marca, String modelo, Date anoDeFabricacao, String placa, double valorDiaria, double valorDeBem, double porcentagem) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
        this.placa = placa;
        this.valorDiaria = valorDiaria;
        this.valorDeBem = valorDeBem;
        this.porcentagem = porcentagem;
        this.alugado = false;
        this.quantidadeAlugueisFechados = 0;
        this.clienteAlugou = null;
    }

    public double seguroDiario(){
        return (valorDeBem * porcentagem) / 365;
    }

    public double aluguel(int quantidadeDeDias){
        return (valorDiaria + seguroDiario()) * quantidadeDeDias;
    }

    public void depreciarVeiculo(double percentual){
        valorDeBem -= (valorDeBem * percentual);
    }

    public void apreciarVeiculo(double percentual){
        valorDeBem += valorDeBem * percentual;
    }

    public void diminuirDiaria(double percentual){
        valorDiaria -= valorDiaria * percentual;
    }

    public void aumentarDiaria(double percentual){
        valorDiaria += valorDiaria * percentual;
    }

    public String getMarca() {
        return marca;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public String getModelo() {
        return modelo;
    }

    public Date getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public String getPlaca() {
        return placa;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public double getValorDeBem() {
        return valorDeBem;
    }

    public boolean isAlugado(){
        return this.alugado;
    }

    public int getQuantidadeAlugueisFechados() {
        return quantidadeAlugueisFechados;
    }

    public Cliente getClienteAlugou() {
        return clienteAlugou;
    }

    public void setClienteAlugou(Cliente clienteAlugou) {
        this.clienteAlugou = clienteAlugou;
    }

    public void alugar(){
        this.alugado = true;
    }

    public void devolver(){
        this.alugado = false;
        quantidadeAlugueisFechados++;
    }
}
