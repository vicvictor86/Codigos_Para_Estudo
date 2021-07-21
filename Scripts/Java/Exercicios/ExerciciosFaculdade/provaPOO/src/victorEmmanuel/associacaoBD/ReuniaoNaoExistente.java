package victorEmmanuel.associacaoBD;

public class ReuniaoNaoExistente extends Exception{
    public ReuniaoNaoExistente(){
        super("Reunião não existente");
    }
}
