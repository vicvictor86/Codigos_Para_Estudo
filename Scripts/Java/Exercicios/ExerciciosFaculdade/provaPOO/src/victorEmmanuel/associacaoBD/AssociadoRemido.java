package victorEmmanuel.associacaoBD;

import java.sql.SQLException;

public class AssociadoRemido extends Associado{

    private long dataRemissao;

    public AssociadoRemido(int numero, String nome, String telefone, long dataAssociacao, long nascimento, long dataRemissao) {
        super(numero, nome, telefone, dataAssociacao, nascimento);
        this.dataRemissao = dataRemissao;
    }
    
    public AssociadoRemido(int numero, String nome, String telefone, long dataAssociacao, long nascimento, long dataRemissao, Associacao associacao) throws SQLException {
        super(numero, nome, telefone, dataAssociacao, nascimento, associacao);
        this.dataRemissao = dataRemissao;
    }

    public long getDataRemissao() {
        return dataRemissao;
    }

    public void setDataRemissao(long dataRemissao) {
        this.dataRemissao = dataRemissao;
    }
}
