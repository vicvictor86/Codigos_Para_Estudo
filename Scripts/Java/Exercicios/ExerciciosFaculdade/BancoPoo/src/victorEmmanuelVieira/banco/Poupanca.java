package victorEmmanuelVieira.banco;

public class Poupanca extends Conta{
    public void renderJuros(double juro){
        credito(getSaldo() * juro);
    }
}
