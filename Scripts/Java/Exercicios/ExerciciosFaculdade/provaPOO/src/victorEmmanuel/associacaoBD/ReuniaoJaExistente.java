package victorEmmanuel.associacaoBD;

public class ReuniaoJaExistente extends Exception{
    public ReuniaoJaExistente(){
        super("Reuniao já existente");
    }
}
