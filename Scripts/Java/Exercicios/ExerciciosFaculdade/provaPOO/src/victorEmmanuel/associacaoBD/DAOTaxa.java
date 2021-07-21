package victorEmmanuel.associacaoBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOTaxa {
	public void salvar(Taxa t) throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "select * from taxa where nome = " + t.getNome();
		System.out.println(cmd);

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);

		if (rs.next()) {
			remover(t);
		}

		inserir(t, t.getAssociacao().getNum());
		st.close();
	}

	public void inserir(Taxa t, int associacao) throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "insert into taxa (nome, vigencia, valor, parcelas, administrativa, associacao) values (\'"
				+ t.getNome() + "\', " + t.getVigencia() + "," + t.getValorAno() + ", " + t.getParcelas() + ", "
				+ t.isAdministrativa() + ", " + associacao + ");";
		System.out.println(cmd);

		DAOAssociacao daoAssociacao = new DAOAssociacao();
		Associacao associacaoDesejada = daoAssociacao.recuperar(associacao);

		ArrayList<Taxa> taxas = associacaoDesejada.getTaxasAssociados();
		ArrayList<Taxa> taxasDoBanco = this.recuperar(associacaoDesejada);

		boolean encontrado = false;

		for (Taxa taxaBanco : taxasDoBanco) {

			if (t.getNome().equals(taxaBanco.getNome()) && t.getVigencia() == taxaBanco.getVigencia()) {
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			Statement st = con.createStatement();
			st.executeUpdate(cmd);
			taxas.add(t);
			st.close();
		}
	}

	public void alterar(Taxa t) throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "UPDATE taxa SET valor = " + t.getValorAno() + ", parcelas = " + t.getParcelas()
				+ " WHERE numero = " + t.getNome();
		System.out.println(cmd);

		Statement st = con.createStatement();
		st.executeUpdate(cmd);

		st.close();
	}

	public void remover(Taxa t) throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "delete from taxa where numero = " + t.getNome();
		System.out.println(cmd);

		Statement st = con.createStatement();
		st.executeUpdate(cmd);

		st.close();
	}

	public void removerTodos() throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "delete from taxa";
		System.out.println(cmd);

		Statement st = con.createStatement();
		st.executeUpdate(cmd);

		st.close();
	}

	public Taxa recuperar(int associacao, String nome) throws SQLException {
		Connection con = Conexao.getConexao();
		DAOAssociacao daoAssociacao = new DAOAssociacao();

		String cmd = "select * from taxa where nome = \'" + nome + "\' and associacao = " + associacao;
		System.out.println(cmd);

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);

		Taxa t = null;

		if (rs.next()) {
			String nomeTaxa = rs.getString("nome");
			int vigencia = rs.getInt("vigencia");
			double valor = rs.getDouble("valor");
			int parcelas = rs.getInt("parcelas");
			boolean administrativa = rs.getBoolean("administrativa");
			int numAssociacao = rs.getInt("associacao");

			Associacao associcaoObjeto = daoAssociacao.recuperar(numAssociacao);
			t = new Taxa(nomeTaxa, vigencia, valor, parcelas, administrativa, associcaoObjeto);
		}

		st.close();
		return t;
	}

	public ArrayList<Taxa> recuperar(Associacao assoc) throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "select * from taxa where associacao = " + assoc.getNum();
		System.out.println(cmd);

		ArrayList<Taxa> taxas = new ArrayList<Taxa>();

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);

		while (rs.next()) {
			String nomeTaxa = rs.getString("nome");
			int vigencia = rs.getInt("vigencia");
			double valor = rs.getDouble("valor");
			int parcelas = rs.getInt("parcelas");
			boolean administrativa = rs.getBoolean("administrativa");

			taxas.add(new Taxa(nomeTaxa, vigencia, valor, parcelas, administrativa, assoc));
		}

		st.close();
		return taxas;
	}

	public ArrayList<Taxa> recuperarTodos() throws SQLException {
		Connection con = Conexao.getConexao();
		DAOAssociacao daoAssociacao = new DAOAssociacao();

		String cmd = "select * from taxa;";
		System.out.println(cmd);

		ArrayList<Taxa> taxa = new ArrayList<Taxa>();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);

		while (rs.next()) {
			String nome = rs.getString("nome");
			int vigencia = rs.getInt("vigencia");
			double valor = rs.getDouble("valor");
			int parcelas = rs.getInt("parcelas");
			boolean administrativa = rs.getBoolean("administrativa");
			int associacao = rs.getInt("associacao");

			Associacao associcaoObjeto = daoAssociacao.recuperar(associacao);
			taxa.add(new Taxa(nome, vigencia, valor, parcelas, administrativa, associcaoObjeto));
		}

		st.close();
		return taxa;
	}
}
