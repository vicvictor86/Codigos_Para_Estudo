package victorEmmanuel.associacaoBD;

public class TaxaNaoExistente extends Exception{
    public TaxaNaoExistente(){
        super("Taxa não existente");
    }
}
