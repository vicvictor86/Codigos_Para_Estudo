package victorEmmanuel.associacao;

public class TaxaJaExistente extends Exception{
    public TaxaJaExistente() {
        super("Taxa já existente");
    }
}
