package victorEmmanuel.associacaoBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DAOPagamento {

    public void inserir(LogPagamento a) throws SQLException, ValorInvalido, TaxaNaoExistente, AssociadoJaRemido {
        Connection con = Conexao.getConexao();

        String cmd = "insert into pagamento (data, valor, associado, vigencia, taxa, associacao) values ("
                + a.getData() + ", " + a.getValor() + ", " + a.getAssociado().getNumero() + ", " + a.getVigencia() + ", \'"
                + a.getTaxa().getNome() + "\', " + a.getAssociado().getAssociacao().getNum() + ");";
        System.out.println(cmd);

        Statement st = con.createStatement();
        st.executeUpdate(cmd);
        a.getTaxa().getLogPagamentos().add(a);
        
        st.close();
    }

    public void alterar(LogPagamento a) throws SQLException {
        Connection con = Conexao.getConexao();

        String cmd = "UPDATE pagamento SET valor = \'" + a.getValor() + "\'" + ", associado = " + a.getAssociado()
                + ", vigencia = \'" + a.getVigencia() + "\', taxa = " + a.getTaxa()
                + ", associacao = " + a.getAssociado().getAssociacao() + " WHERE associado = " + a.getAssociado().getNumero();
        System.out.println(cmd);

        Statement st = con.createStatement();
        st.executeUpdate(cmd);

        st.close();
    }

    public void remover(Associado associado) throws SQLException {
        Connection con = Conexao.getConexao();

        String cmd = "delete from pagamento where associado = " + associado.getNumero();
        System.out.println(cmd);

        Statement st = con.createStatement();
        st.executeUpdate(cmd);

        st.close();
    }

    public void removerTodos() throws SQLException {
        Connection con = Conexao.getConexao();

        String cmd = "delete from pagamento";
        System.out.println(cmd);

        Statement st = con.createStatement();
        st.executeUpdate(cmd);

        st.close();
    }

    public ArrayList<LogPagamento> recuperar(Associado associado) throws SQLException {
        Connection con = Conexao.getConexao();
        DAOTaxa daoTaxa = new DAOTaxa();

        String cmd = "select * from pagamento where associado = " + associado.getNumero();
        System.out.println(cmd);

        ArrayList<LogPagamento> pagamentos = new ArrayList<LogPagamento>();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(cmd);

        while (rs.next()) {
            long data = rs.getLong("data");
            double valor = rs.getDouble("valor");
            int vigencia = rs.getInt("vigencia");
            Taxa taxa = daoTaxa.recuperar(associado.getAssociacao().getNum(), rs.getString("taxa"));
            pagamentos.add(new LogPagamento(data, valor, associado, taxa, vigencia));
        }

        st.close();
        return pagamentos;
    }

    public ArrayList<LogPagamento> recuperar(Taxa taxa) throws SQLException {
        Connection con = Conexao.getConexao();
        DAOAssociado daoAssociado = new DAOAssociado();

        String cmd = "select * from pagamento where taxa = \'" + taxa.getNome() + "\'";
        System.out.println(cmd);

        ArrayList<LogPagamento> pagamentos = new ArrayList<LogPagamento>();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(cmd);

        while (rs.next()) {
            long data = rs.getLong("data");
            double valor = rs.getDouble("valor");
            int vigencia = rs.getInt("vigencia");
            Associado associado = daoAssociado.recuperarPorNumero(rs.getInt("associado"));
            pagamentos.add(new LogPagamento(data, valor, associado, taxa, vigencia));
        }

        st.close();
        return pagamentos;
    }
    
    public ArrayList<LogPagamento> recuperarTodos() throws SQLException {
        Connection con = Conexao.getConexao();
        DAOAssociado daoAssociado = new DAOAssociado();
        DAOTaxa daoTaxa = new DAOTaxa();

        String cmd = "select * from pagamento";
        System.out.println(cmd);

        ArrayList<LogPagamento> pagamentos = new ArrayList<LogPagamento>();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(cmd);

        while (rs.next()) {
            long data = rs.getLong("data");
            double valor = rs.getDouble("valor");
            int vigencia = rs.getInt("vigencia");
            Associado associado = daoAssociado.recuperarPorNumero(rs.getInt("associado"));
            Taxa taxa = daoTaxa.recuperar(rs.getInt("associacao"), rs.getString("taxa"));
            pagamentos.add(new LogPagamento(data, valor, associado, taxa, vigencia));
        }

        st.close();
        return pagamentos;
    }
}
