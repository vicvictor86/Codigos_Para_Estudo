package victorEmmanuel.associacaoBD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

public class TesteDAOAssociacao {

	@Test
	public void testarIncluirRecuperarAssociacao() throws SQLException {
		Associacao a = new Associacao(10, "Casa PASN");
		DAOAssociacao dao = new DAOAssociacao();
		dao.removerTodos();
		dao.inserir(a);
		Associacao outra = dao.recuperar(10);
		assertEquals(10, outra.getNum());
		assertEquals("Casa PASN", outra.getNome());
	}
	
	@Test
	public void testarDeletarAssociacao() throws SQLException {
		Associacao a = new Associacao(10, "Casa PASN");
		DAOAssociacao dao = new DAOAssociacao();
		dao.removerTodos();
		dao.inserir(a);
		dao.remover(10);
		Associacao outra = dao.recuperar(10);
		assertEquals(null, outra);
	}
	
	@Test
	public void testarAlterarAssociacao() throws SQLException {
		Associacao a = new Associacao(10, "Casa PASN");
		DAOAssociacao dao = new DAOAssociacao();
		dao.removerTodos();
		dao.inserir(a);
		Associacao outro = new Associacao(10, "Hello");
		dao.alterar(outro);
		Associacao outra = dao.recuperar(10);
		assertEquals("Hello", outra.getNome());
	}
	
	@Test
	public void testarInsercaoDeTaxa() throws SQLException, AssociacaoJaExistente, ValorInvalido, AssociacaoNaoExistente, TaxaJaExistente {
		InterfaceAssociacao controle = new MinhaAssociacao();
		
		Associacao a = new Associacao(10, "Casa PASN");
		DAOAssociacao dao = new DAOAssociacao();
		dao.removerTodos();
		DAOTaxa daoTaxa = new DAOTaxa();
		daoTaxa.removerTodos();
		
		System.out.println("OLHA AQUI MEU MAJOR");
		for (Taxa taxa : daoTaxa.recuperar(a)) {
			System.out.println(taxa.getNome());
		}
		
		Taxa t1 = new Taxa("Mensalidade", 2021, 120, 12, true, a);
		Taxa t2 = new Taxa("Mensalidade", 2020, 60, 6, false, a);
		Taxa t3 = new Taxa("Social", 2021, 240, 12, false, a);
		Taxa t4 = new Taxa("Letrado", 2021, 240, 12, false, a);
		Taxa t5 = new Taxa("Robson", 2021, 240, 12, false, a);
		
		controle.adicionar(a);
		controle.adicionar(10, t1);
		controle.adicionar(10, t2);
		controle.adicionar(10, t3);
		try {
			controle.adicionar(10, t3);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		Associacao outra1 = dao.recuperar(10);
		
		assertEquals(3, outra1.getTaxasAssociados().size());
		
		try {
			controle.adicionar(10, t4);
			controle.adicionar(10, t4);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Associacao outra = dao.recuperar(10);
		
		controle.adicionar(10, t5);
		
		
		assertEquals("Casa PASN", outra.getNome());
		assertEquals(5, outra.getTaxasAssociados().size());
		
	}
}
