public class Produto {
    String codigo = "";
    String descricao = "";
    double precoCompra = 0.0;
    double precoVenda = 0.0;
    int quantidade = 0;
    int estoqueMinimo = 0;

    void Compra(int quant, double val){
        quantidade += quant;
        precoCompra = val;
    }

    double Venda(int quant){
        quantidade -= quant;
        return precoVenda;
    }
}
