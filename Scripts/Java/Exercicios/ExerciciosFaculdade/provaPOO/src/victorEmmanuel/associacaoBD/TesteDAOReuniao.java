package victorEmmanuel.associacaoBD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

public class TesteDAOReuniao {
	@Test
	public void testarInsercaoDeReuniao() throws SQLException, ValorInvalido, TaxaNaoExistente, AssociadoJaRemido, AssociacaoJaExistente, AssociacaoNaoExistente, AssociadoJaExistente, AssociadoNaoExistente, TaxaJaExistente, ReuniaoJaExistente {
		InterfaceAssociacao controle = new MinhaAssociacao();
		Associacao a = new Associacao(10, "Casa PASN");
		DAOAssociacao daoAssociacao = new DAOAssociacao();
		daoAssociacao.removerTodos();
		
		DAOReuniao daoReuniao = new DAOReuniao(); 
		daoReuniao.removerTodos();
		
		Reuniao t1 = new Reuniao(5165156, "teste1", a);
		Reuniao t2 = new Reuniao(51651561, "teste2", a);
		Reuniao t3 = new Reuniao(516515612, "teste3", a);
		
		controle.adicionar(a);
		controle.adicionar(10, t1);
		controle.adicionar(10, t2);
		
		
		Associacao outra = daoAssociacao.recuperar(10);
		
		assertEquals(2, outra.getReunioes().size());
		
		controle.adicionar(10, t3);
		
		Associacao outraa = daoAssociacao.recuperar(10);
		
		assertEquals(3, outraa.getReunioes().size());
		
	}
	
	@Test
	public void testarInsercaoDeReuniaoEFrequencia() throws SQLException, ValorInvalido, TaxaNaoExistente, AssociadoJaRemido, AssociacaoJaExistente, AssociacaoNaoExistente, AssociadoJaExistente, AssociadoNaoExistente, TaxaJaExistente, ReuniaoJaExistente, ReuniaoNaoExistente, FrequenciaJaRegistrada, FrequenciaIncompativel {
		InterfaceAssociacao controle = new MinhaAssociacao();
		Associacao a = new Associacao(10, "Casa PASN");
		DAOAssociacao daoAssociacao = new DAOAssociacao();
		daoAssociacao.removerTodos();
		
		DAOReuniao daoReuniao = new DAOReuniao(); 
		daoReuniao.removerTodos();
		
		DAOAssociado daoAssociado = new DAOAssociado();
		daoAssociado.removerTodos();
		
		DAOFrequencia daoFrequencia = new DAOFrequencia();
		daoFrequencia.removerTodos();
		
		Reuniao t1 = new Reuniao(5165156, "teste1", a);
		Reuniao t2 = new Reuniao(51651561, "teste2", a);
		Reuniao t3 = new Reuniao(516515612, "teste3", a);
		
		controle.adicionar(a);
		controle.adicionar(10, t1);
		controle.adicionar(10, t2);
		controle.adicionar(10, t3);
		
		
		Associado associadoA = new Associado(1, "Robson", "1235456", 123123, 12092001, a);
		Associado associadoB = new Associado(2, "Clara", "1235456", 123123, 12092001, a);
		Associado associadoC = new Associado(3, "Diego", "1235456", 123123, 12092001, a);
		
		controle.adicionar(10, associadoA);
		controle.adicionar(10, associadoB);
		controle.adicionar(10, associadoC);
		
		Associacao outra = daoAssociacao.recuperar(10);
		
		assertEquals(3, outra.getReunioes().size());
		
		controle.registrarFrequencia(associadoA.getNumero(), associadoA.getAssociacao().getNum(), t1.getData());
		controle.registrarFrequencia(associadoB.getNumero(), associadoB.getAssociacao().getNum(), t1.getData());
		controle.registrarFrequencia(associadoB.getNumero(), associadoB.getAssociacao().getNum(), t2.getData());
		
		Reuniao outraa = daoReuniao.recuperar(t1.getData());
		Reuniao outraa2 = daoReuniao.recuperar(t2.getData());
		
		assertEquals(2, outraa.getParticipantes().size());
		assertEquals(1, outraa2.getParticipantes().size());
		
	}
	
	@Test
	public void testarInsercaoDeReuniaoEFrequencia2() throws SQLException, ValorInvalido, TaxaNaoExistente, AssociadoJaRemido, AssociacaoJaExistente, AssociacaoNaoExistente, AssociadoJaExistente, AssociadoNaoExistente, TaxaJaExistente, ReuniaoJaExistente, ReuniaoNaoExistente, FrequenciaJaRegistrada, FrequenciaIncompativel {
		InterfaceAssociacao controle = new MinhaAssociacao();
		Associacao a = new Associacao(10, "Casa PASN");
		DAOAssociacao daoAssociacao = new DAOAssociacao();
		daoAssociacao.removerTodos();
		
		DAOReuniao daoReuniao = new DAOReuniao(); 
		daoReuniao.removerTodos();
		
		DAOAssociado daoAssociado = new DAOAssociado();
		daoAssociado.removerTodos();
		
		DAOFrequencia daoFrequencia = new DAOFrequencia();
		daoFrequencia.removerTodos();
		
		Reuniao t1 = new Reuniao(5165156, "teste1", a);
		Reuniao t2 = new Reuniao(51651561, "teste2", a);
		Reuniao t3 = new Reuniao(516515612, "teste3", a);
		
		controle.adicionar(a);
		controle.adicionar(10, t1);
		controle.adicionar(10, t2);
		controle.adicionar(10, t3);
		
		
		Associado associadoA = new Associado(1, "Robson", "1235456", 123123, 12092001, a);
		Associado associadoB = new Associado(2, "Clara", "1235456", 123123, 12092001, a);
		Associado associadoC = new Associado(3, "Diego", "1235456", 123123, 12092001, a);
		
		controle.adicionar(10, associadoA);
		controle.adicionar(10, associadoB);
		controle.adicionar(10, associadoC);
		
		Associacao outra = daoAssociacao.recuperar(10);
		
		assertEquals(3, outra.getReunioes().size());
		
		controle.registrarFrequencia(associadoA.getNumero(), associadoA.getAssociacao().getNum(), t1.getData());
		controle.registrarFrequencia(associadoB.getNumero(), associadoB.getAssociacao().getNum(), t1.getData());
		controle.registrarFrequencia(associadoB.getNumero(), associadoB.getAssociacao().getNum(), t2.getData());
		controle.registrarFrequencia(associadoA.getNumero(), associadoA.getAssociacao().getNum(), t2.getData());
		
		Reuniao outraa = daoReuniao.recuperar(t1.getData());
		Reuniao outraa2 = daoReuniao.recuperar(t2.getData());
		
		double calculo = controle.calcularFrequencia(associadoA.getNumero(), associadoA.getAssociacao().getNum(), t1.getData(), t2.getData());
		
		assertEquals(1, calculo);
		assertEquals(2, outraa.getParticipantes().size());
		assertEquals(2, outraa2.getParticipantes().size());
		
	}
}
