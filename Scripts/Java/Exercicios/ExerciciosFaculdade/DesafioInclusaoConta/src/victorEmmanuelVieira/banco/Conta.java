package victorEmmanuelVieira.banco;

public class Conta {

    private int numero;
    private double saldo;
    private String extrato = "";
    private PessoaFisica titular;

    public int getNum() {
        return numero;
    }

    public void setNum(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public PessoaFisica getTitular() {
        return titular;
    }

    public void setTitular(PessoaFisica titular) {
        this.titular = titular;
    }

    public String getExtrato() {
        return extrato;
    }

    public void credito(double valor){
        if(valor > 0){
            this.saldo += valor;
            extrato = extrato + "Crédito: " + valor +
                    ". Saldo: " + getSaldo() + ".\n";
        }else{
            System.out.println("O valor colocado não é aceito");
        }
    }

    public void debito(double valor){
        if(saldo > 0){
            this.saldo -= valor;
            extrato = extrato + "Débito: " + valor +
                    ". Saldo: " + getSaldo() + ".\n";
        }else{
            System.out.println("A conta " + numero + "não possui saldo suficiente");
        }
    }

}
