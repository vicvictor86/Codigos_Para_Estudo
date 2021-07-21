package victorEmmanuel.associacaoBD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

public class TesteDAOAssociado {
	@Test
	public void testarIncluirRecuperarAssociacadoEmUmaAssociacao() throws SQLException, Exception {

		InterfaceAssociacao controle = new MinhaAssociacao();

		Associacao a = new Associacao(12, "Casa PASN");
		DAOAssociacao dao = new DAOAssociacao();
		dao.removerTodos();
		DAOAssociado daoAssociado = new DAOAssociado();
		daoAssociado.removerTodos();

		Associado t1 = new Associado(1, "Robson", "1235456", 123123, 12092001, a);
		Associado t2 = new Associado(2, "Clara", "1235456", 123123, 12092001, a);
		Associado t3 = new Associado(3, "Diego", "1235456", 123123, 12092001, a);
		Associado t4 = new Associado(4, "Carol", "1235456", 123123, 12092001, a);
		Associado t5 = new Associado(5, "Sheyla", "1235456", 123123, 12092001, a);

		controle.adicionar(a);
		controle.adicionar(12, t1);
		controle.adicionar(12, t2);
		controle.adicionar(12, t3);
		
		try {
			controle.adicionar(12, t3);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		

		Associacao outra1 = dao.recuperar(12);

		assertEquals(3, outra1.getAssociados().size());

		try {
			controle.adicionar(12, t4);
			controle.adicionar(12, t4);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Associacao outra = dao.recuperar(12);

		controle.adicionar(12, t5);

		assertEquals("Casa PASN", outra.getNome());
		assertEquals(5, outra.getAssociados().size());

	}

	@Test
	public void testarTudo() throws SQLException, Exception {

		Associacao a = new Associacao(10, "Casa PASN");
		DAOAssociado daoAssociado = new DAOAssociado();
		DAOAssociacao daoAssociacao = new DAOAssociacao();

		daoAssociacao.removerTodos();
		daoAssociado.removerTodos();

		Associacao associacao = new Associacao(123, "Associacao1");
		daoAssociacao.inserir(associacao);

		Associado associadoA = new Associado(1, "Diego", "5519456", 213323, 132156, daoAssociacao.recuperar(123));
		Associado associadoB = new Associado(2, "Carlos", "5519456", 213323, 132156, daoAssociacao.recuperar(123));
		Associado associadoC = new Associado(3, "Vanderlei", "5519456", 213323, 132156, daoAssociacao.recuperar(123));
		daoAssociado.inserir(associadoA, 123);
		daoAssociado.inserir(associadoB, 123);
		daoAssociado.inserir(associadoC, 123);

		Associacao outra = daoAssociacao.recuperar(123);

		for (Associado associadoAtual : daoAssociado.recuperar(a)) {
			outra.adicionarAssociado(associadoAtual);
		}

		assertEquals("Diego", outra.pesquisaAssociado(1).getNome());
		assertEquals("Carlos", outra.pesquisaAssociado(2).getNome());
		assertEquals("Vanderlei", outra.pesquisaAssociado(3).getNome());

	}

}
