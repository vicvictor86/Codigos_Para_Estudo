package victorEmmanuelVieira.banco;

public class ContaInexistente extends Exception{

    public ContaInexistente(){
        super("Tentativa de acesso a conta que não existe");
    }
}
