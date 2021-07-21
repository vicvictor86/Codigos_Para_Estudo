package victorEmmanuel.associacaoBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOReuniao {
	public void inserir(Reuniao a, int associacao) throws SQLException {
		Connection con = Conexao.getConexao();
		
		String cmd = "insert into reuniao (pauta, data, associacao) values (\'"
		     + a.getAta() + "\', " + a.getData() + ", " + associacao + ")";
		System.out.println(cmd);
		
		Statement st = con.createStatement();
	    st.executeUpdate(cmd);
	    
	    DAOAssociacao daoAssociacao = new DAOAssociacao();
		Associacao associacaoDesejada = daoAssociacao.recuperar(associacao);
		associacaoDesejada.getReunioes().add(a);

	    st.close();
	}

	public void alterar(Reuniao a) throws SQLException {
		Connection con = Conexao.getConexao();
		
		String cmd = "UPDATE reuniao SET pauta = \'" + a.getAta() + "\' WHERE data = " + a.getData();
		System.out.println(cmd);
		
		Statement st = con.createStatement();
	    st.executeUpdate(cmd);
	    
	    st.close();
	}

	public void remover(long n) throws SQLException {
		Connection con = Conexao.getConexao();
		
		String cmd = "delete from reunio where data = " + n;
		System.out.println(cmd);
		
		Statement st = con.createStatement();
	    st.executeUpdate(cmd);
	    
	    st.close();
	}
	
	public void removerTodos() throws SQLException {
		Connection con = Conexao.getConexao();
		
		String cmd = "delete from reuniao";
		System.out.println(cmd);
		
		Statement st = con.createStatement();
	    st.executeUpdate(cmd);
	    
	    st.close();
	}

	public Reuniao recuperar(long dataProcurada) throws SQLException {
		Connection con = Conexao.getConexao();
		
		String cmd = "select * from reuniao where data = " + dataProcurada;
		System.out.println(cmd);
		
		Reuniao reuniaoRecuperada = null;
		Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery(cmd);
	    
	    if (rs.next()) {
	    	String pauta = rs.getString("pauta");
	    	long data = rs.getLong("data");
	    	int associacao = rs.getInt("associacao");
	    	DAOAssociacao daoAssociacao = new DAOAssociacao();
			reuniaoRecuperada = new Reuniao(data, pauta, daoAssociacao.recuperar(associacao));
	    }
	    
	    st.close();
	    return reuniaoRecuperada;
	}

	public ArrayList<Reuniao> recuperar(int associacao) throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "select * from reuniao where associacao = " + associacao;
		System.out.println(cmd);

		ArrayList<Reuniao> reunioesRecuperadas = new ArrayList<Reuniao>();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);

		while (rs.next()) {
			String pauta = rs.getString("pauta");
			long data = rs.getLong("data");
			DAOAssociacao daoAssociacao = new DAOAssociacao();
			reunioesRecuperadas.add(new Reuniao(data, pauta, daoAssociacao.recuperar(associacao)));
		}

		st.close();
		return reunioesRecuperadas;
	}
	
	public ArrayList<Reuniao> recuperarTodos() throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "select * from reuniao;";
		System.out.println(cmd);

		ArrayList<Reuniao> reunioes = new ArrayList<Reuniao>();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);
		
		while (rs.next()) {
			String pauta = rs.getString("pauta");
			long data = rs.getLong("data");
			int associacao = rs.getInt("associacao");
			DAOAssociacao daoAssociacao = new DAOAssociacao();
			reunioes.add(new Reuniao(data, pauta, daoAssociacao.recuperar(associacao)));
		}

		st.close();
		return reunioes;
	}	
}
