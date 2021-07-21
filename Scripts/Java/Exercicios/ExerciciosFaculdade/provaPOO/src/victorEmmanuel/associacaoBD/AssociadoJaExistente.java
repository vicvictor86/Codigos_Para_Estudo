package victorEmmanuel.associacaoBD;

public class AssociadoJaExistente extends Exception{
    public AssociadoJaExistente(){
        super("Associado já existente");
    }
}
