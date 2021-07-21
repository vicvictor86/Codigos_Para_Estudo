package victorEmmanuel.associacaoBD;

public class TaxaJaExistente extends Exception{
    public TaxaJaExistente() {
        super("Taxa já existente");
    }
}
