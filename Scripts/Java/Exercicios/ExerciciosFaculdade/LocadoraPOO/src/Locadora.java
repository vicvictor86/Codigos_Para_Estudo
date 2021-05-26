import java.util.ArrayList;

public interface Locadora {

	public void inserir(Veiculo v) throws VeiculoJaCadastrado;
	public void inserir(Cliente c) throws ClienteJaCadastrado;
	public Veiculo pesquisar(String placa) throws VeiculoNaoCadastrado; 
	
    public ArrayList<Veiculo> pesquisarMoto(int cilindrada);
    public ArrayList<Veiculo> pesquisarCarro(int tipoCarro);
    public ArrayList<Veiculo> pesquisarCaminhao(int carga);
    public ArrayList<Veiculo> pesquisarOnibus(int passageiros);
    
    public double calcularAluguel(String placa, int dias) throws VeiculoNaoCadastrado;
    public void registrarAluguel(String placa, int dias, Cliente c) throws VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado;
    public void registrarDevolucao(String placa, Cliente c) throws VeiculoNaoCadastrado, VeiculoNaoAlugado, ClienteNaoCadastrado;
   
    public void depreciarVeiculos(int tipo, double taxaDepreciacao);
    public void aumentarDiaria(int tipo, double taxaAumento);
    public double faturamentoTotal(int tipo);
    public int quantidadeTotalDeDiarias(int tipo);
}
