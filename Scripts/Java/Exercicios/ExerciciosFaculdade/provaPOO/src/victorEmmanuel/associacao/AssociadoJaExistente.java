package victorEmmanuel.associacao;

public class AssociadoJaExistente extends Exception{
    public AssociadoJaExistente(){
        super("Associado já existente");
    }
}
