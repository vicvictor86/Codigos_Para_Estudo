package victorEmmanuel.associacaoBD;

public class AssociadoNaoExistente extends Exception{
    public AssociadoNaoExistente(){
        super("Associado não existente");
    }
}
