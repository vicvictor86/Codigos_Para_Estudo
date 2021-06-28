package victorEmmanuel.associacao;

import java.util.ArrayList;

public class Reuniao {
    private long data;
    private String ata;
    private ArrayList<Associado> participantes = new ArrayList<Associado>();

    public Reuniao(long data, String ata) {
        this.data = data;
        this.ata = ata;
    }

    public long getData() {
        return data;
    }

    public String getAta() {
        return ata;
    }

    public void setData(long data) {
        this.data = data;
    }

    public void setAta(String ata) {
        this.ata = ata;
    }

    public Associado pesquisaParticipante(int codigoAssociado) throws AssociadoNaoExistente {
        for (Associado participanteAtual : participantes) {
            if(participanteAtual.getNumero() == codigoAssociado){
                return participanteAtual;
            }
        }
        throw new AssociadoNaoExistente();
    }

    public void adicionarParticipante(Associado participante){
        participantes.add(participante);
    }
}
