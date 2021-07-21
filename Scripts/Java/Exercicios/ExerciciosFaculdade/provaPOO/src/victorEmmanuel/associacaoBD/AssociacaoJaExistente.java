package victorEmmanuel.associacaoBD;

public class AssociacaoJaExistente extends Exception{
    public AssociacaoJaExistente(){
        super("Associação já existente");
    }
}
