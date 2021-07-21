package victorEmmanuel.associacaoBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOAssociacao {

	public void inserir(Associacao a) throws SQLException {
		Connection con = Conexao.getConexao();
		
		String cmd = "insert into associacao (numero, nome) values (" 
		     + a.getNum() + ", \'" + a.getNome() + "\')";
		System.out.println(cmd);
		
		Statement st = con.createStatement();
	    st.executeUpdate(cmd);

	    st.close();
	}

	public void alterar(Associacao a) throws SQLException {
		Connection con = Conexao.getConexao();
		
		String cmd = "UPDATE associacao SET nome = \'" + a.getNome() + "\' WHERE numero = " + a.getNum();
		System.out.println(cmd);
		
		Statement st = con.createStatement();
	    st.executeUpdate(cmd);
	    
	    st.close();
	}

	public void remover(int n) throws SQLException {
		Connection con = Conexao.getConexao();
		
		String cmd = "delete from associacao where numero = " + n;
		System.out.println(cmd);
		
		Statement st = con.createStatement();
	    st.executeUpdate(cmd);
	    
	    st.close();
	}
	
	public void removerTodos() throws SQLException {
		Connection con = Conexao.getConexao();
		
		String cmd = "delete from associacao";
		System.out.println(cmd);
		
		Statement st = con.createStatement();
	    st.executeUpdate(cmd);
	    
	    st.close();
	}

	public Associacao recuperar(int n) throws SQLException {
		Connection con = Conexao.getConexao();
		
		String cmd = "select * from associacao where numero = " + n;
		System.out.println(cmd);
		
		Associacao a = null;
		Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery(cmd);
	    
	    if (rs.next()) {
	    	int num  = rs.getInt("numero");
	    	String nome = rs.getString("nome");
	    	a = new Associacao(num, nome);
	    }
	    
	    st.close();
	    return a;
	}
	
	public ArrayList<Associacao> recuperarTodos() throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "select * from associacao;";
		System.out.println(cmd);

		ArrayList<Associacao> associacoes = new ArrayList<Associacao>();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);
		
		while (rs.next()) {
			int num = rs.getInt("numero");
			String nome = rs.getString("nome");
			associacoes.add(new Associacao(num, nome));
		}

		st.close();
		return associacoes;
	}	
	
}
