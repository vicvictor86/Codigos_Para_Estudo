package victorEmmanuel.associacao;

public class AssociacaoJaExistente extends Exception{
    public AssociacaoJaExistente(){
        super("Associação já existente");
    }
}
