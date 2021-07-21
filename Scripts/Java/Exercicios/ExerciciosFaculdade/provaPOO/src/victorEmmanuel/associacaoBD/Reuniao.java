package victorEmmanuel.associacaoBD;

import java.sql.SQLException;
import java.util.ArrayList;

public class Reuniao {
	private long data;
	private String ata;
	private ArrayList<Frequencia> participantes = new ArrayList<Frequencia>();
	private Associacao associacao;

	public Reuniao(long data, String ata, Associacao associacao) {
		this.data = data;
		this.ata = ata;
		this.associacao = associacao;
	}

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

	public ArrayList<Frequencia> getParticipantes() throws SQLException {

		if (participantes.isEmpty()) {
			DAOFrequencia daoFrequencia = new DAOFrequencia();
			participantes = daoFrequencia.recuperar(this.getData());
		}
		return participantes;

	}

	public Associacao getAssociacao() {
		return associacao;
	}

	public void setAssociacao(Associacao associacao) {
		this.associacao = associacao;
	}

	public void setData(long data) {
		this.data = data;
	}

	public void setAta(String ata) {
		this.ata = ata;
	}

	public Frequencia pesquisaFrequencia(int codigoAssociado, long data) throws AssociadoNaoExistente {
		try {
			for (Frequencia participanteAtual : getParticipantes()) {
				if (participanteAtual.getData() == data && participanteAtual.getAssociado() == codigoAssociado) {
					return participanteAtual;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new AssociadoNaoExistente();
	}

	public void adicionarParticipante(long data, int associado, int associacao) throws SQLException {
		DAOFrequencia daoFrequencia = new DAOFrequencia();
		daoFrequencia.inserir(new Frequencia(data, associado, associacao));
		participantes.add(new Frequencia(data, associacao, associado));
	}
}
