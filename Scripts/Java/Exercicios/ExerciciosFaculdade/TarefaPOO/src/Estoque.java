public class Estoque {
    Produto[] produtos = new Produto[20];

    void Compra(int indice, int quantidade, double precoCompra){
        produtos[indice].Compra(quantidade, precoCompra);
    }

    double Venda(int indice, int quantidade, double precoVenda){
        produtos[indice].Venda(quantidade);
        return precoVenda;
    }

    void CriaProduto(int indice, String codigo, String descricao, double precoCompra, double precoVenda, int quantidade, int estoqueMinimo){
        produtos[indice].codigo = codigo;
        produtos[indice].descricao = descricao;
        produtos[indice].precoVenda = precoVenda;
        produtos[indice].precoCompra = precoCompra;
        produtos[indice].quantidade = quantidade;
        produtos[indice].estoqueMinimo = estoqueMinimo;
    }

    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        estoque.produtos[0] = new Produto();

        estoque.Compra(0, 2, 200);
        System.out.println("Quant: " + estoque.produtos[0].quantidade + " valor: " + estoque.produtos[0].precoCompra);

        double preco = estoque.Venda(0, 1, 400);
        System.out.println("Preco: " + preco + " Quant: " + estoque.produtos[0].quantidade);
    }
}
