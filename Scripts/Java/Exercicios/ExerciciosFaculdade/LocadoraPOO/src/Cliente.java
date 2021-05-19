public class Cliente {

    private String nome;
    private String cpf;
    private double precoAluguel;


    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.precoAluguel = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(double precoAluguel) {
        this.precoAluguel = precoAluguel;
    }
}
