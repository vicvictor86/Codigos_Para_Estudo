package victorEmmanuel.associacaoBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOAssociado {

	public void inserir(Associado a, int associacao) throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "insert into associado (numero, nome, nascimento, telefone, data_associacao, associacao, discriminador, data_remissao) values ("
				+ a.getNumero() + ", \'" + a.getNome() + "\'," + a.getNascimento() + ", " + a.getTelefone() + ", "
				+ a.getDataAssociacao() + ", " + associacao;

		if (a instanceof AssociadoRemido) {
			cmd += ", 1, " + ((AssociadoRemido) a).getDataRemissao() + ")";
		} else {
			cmd += ", 0, 0)";
		}

		System.out.println(cmd);

		DAOAssociacao daoAssociacao = new DAOAssociacao();
		Associacao associacaoDesejada = daoAssociacao.recuperar(associacao);

		ArrayList<Associado> associado = associacaoDesejada.getAssociados();
		ArrayList<Associado> associadosDoBanco = this.recuperar(associacaoDesejada);

		boolean encontrado = false;

		for (Associado associadoBanco : associadosDoBanco) {

			if (a.getNumero() == associadoBanco.getNumero()) {
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			Statement st = con.createStatement();
			st.executeUpdate(cmd);
			associado.add(a);
			st.close();
		}
	}

	public void alterar(Associado a) throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "UPDATE associado SET nome = \'" + a.getNome() + "\'" + ", nascimento = " + a.getNascimento()
				+ ", telefone = \'" + a.getTelefone() + "\', dataAssociacao = " + a.getDataAssociacao()
				+ ", associacao = " + a.getAssociacao() + " WHERE numero = " + a.getNumero();
		System.out.println(cmd);

		Statement st = con.createStatement();
		st.executeUpdate(cmd);

		st.close();
	}

	public void remover(int n) throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "delete from associado where numero = " + n;
		System.out.println(cmd);

		Statement st = con.createStatement();
		st.executeUpdate(cmd);

		st.close();
	}

	public void removerTodos() throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "delete from associado";
		System.out.println(cmd);

		Statement st = con.createStatement();
		st.executeUpdate(cmd);

		st.close();
	}

	public ArrayList<Associado> recuperar(Associacao n) throws SQLException {
		Connection con = Conexao.getConexao();
		DAOAssociacao daoAssociacao = new DAOAssociacao();

		String cmd = "select * from associado where associacao = " + n.getNum();
		System.out.println(cmd);

		ArrayList<Associado> associados = new ArrayList<Associado>();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);

		while (rs.next()) {
			int num = rs.getInt("numero");
			String nome = rs.getString("nome");
			String telefone = rs.getString("telefone");
			long dataAssociacao = rs.getLong("data_associacao");
			long nascimento = rs.getLong("nascimento");
			int associacao = rs.getInt("associacao");
			int discriminador = rs.getInt("discriminador");

			if (discriminador == 1) {
				long dataDeRemissao = rs.getLong("discriminador");
				associados.add(new AssociadoRemido(num, nome, telefone, dataAssociacao, nascimento, dataDeRemissao,
						daoAssociacao.recuperar(associacao)));
			} else {
				associados.add(new Associado(num, nome, telefone, dataAssociacao, nascimento,
						daoAssociacao.recuperar(associacao)));
			}

		}

		st.close();
		return associados;
	}

	public Associado recuperarPorNumero(int numero) throws SQLException {
		Connection con = Conexao.getConexao();
		DAOAssociacao daoAssociacao = new DAOAssociacao();

		String cmd = "select * from associado where numero = " + numero;
		System.out.println(cmd);

		Associado associado = null;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);

		while (rs.next()) {
			int num = rs.getInt("numero");
			String nome = rs.getString("nome");
			String telefone = rs.getString("telefone");
			long dataAssociacao = rs.getLong("data_associacao");
			long nascimento = rs.getLong("nascimento");
			int associacao = rs.getInt("associacao");
			int discriminador = rs.getInt("discriminador");

			if (discriminador == 1) {
				long dataDeRemissao = rs.getLong("discriminador");
				associado = new AssociadoRemido(num, nome, telefone, dataAssociacao, nascimento, dataDeRemissao,
						daoAssociacao.recuperar(associacao));
			} else {
				associado = new Associado(num, nome, telefone, dataAssociacao, nascimento,
						daoAssociacao.recuperar(associacao));
			}

		}

		st.close();
		return associado;
	}

}
