package victorEmmanuel.associacaoBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOFrequencia {
	public void inserir(Frequencia a) throws SQLException {
		Connection con = Conexao.getConexao();
		
		String cmd = "insert into frequencia (data, associado, associacao) values (" 
		     + a.getData() + ", " + a.getAssociado() + ", " + a.getAssociacao() + ")";
		System.out.println(cmd);
		
		Statement st = con.createStatement();
	    st.executeUpdate(cmd);

	    st.close();
	}

	public void remover(long n) throws SQLException {
		Connection con = Conexao.getConexao();
		
		String cmd = "delete from frequencia where data = " + n;
		System.out.println(cmd);
		
		Statement st = con.createStatement();
	    st.executeUpdate(cmd);
	    
	    st.close();
	}
	
	public void removerTodos() throws SQLException {
		Connection con = Conexao.getConexao();
		
		String cmd = "delete from frequencia";
		System.out.println(cmd);
		
		Statement st = con.createStatement();
	    st.executeUpdate(cmd);
	    
	    st.close();
	}

	public ArrayList<Frequencia> recuperar(long n) throws SQLException {
		Connection con = Conexao.getConexao();
		
		String cmd = "select * from frequencia where data = " + n;
		System.out.println(cmd);
		
		Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery(cmd);
	    
	    ArrayList<Frequencia> frequencias = new ArrayList<Frequencia>();
	    while (rs.next()) {
	    	long data = rs.getLong("data");
	    	int associado  = rs.getInt("associado");
	    	int associacao = rs.getInt("associacao");
	    	frequencias.add(new Frequencia(data, associacao, associado));
	    }
	    
	    st.close();
	    return frequencias;
	}
	
	public ArrayList<Frequencia> recuperarTodos() throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "select * from frequencia;";
		System.out.println(cmd);

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);
		
		ArrayList<Frequencia> frequencias = new ArrayList<Frequencia>();
		while (rs.next()) {
	    	long data = rs.getLong("data");
	    	int associado  = rs.getInt("associado");
	    	int associacao = rs.getInt("associacao");
	    	frequencias.add(new Frequencia(data, associacao, associado));
	    }

		st.close();
		return frequencias;
	}	
}
