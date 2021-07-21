package victorEmmanuel.associacaoBD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

public class TesteDAOPagamento {
	@Test
	public void testarInsercaoDePagamento() throws SQLException, ValorInvalido, TaxaNaoExistente, AssociadoJaRemido, AssociacaoJaExistente, AssociacaoNaoExistente, AssociadoJaExistente, AssociadoNaoExistente, TaxaJaExistente {
		InterfaceAssociacao controle = new MinhaAssociacao();
		Associacao a = new Associacao(10, "Casa PASN");
		DAOAssociacao daoAssociacao = new DAOAssociacao();
		daoAssociacao.removerTodos();
		
		DAOTaxa daoTaxa = new DAOTaxa();
		daoTaxa.removerTodos();
		
		DAOPagamento daoPagamento = new DAOPagamento();
		daoPagamento.removerTodos();
		
		DAOAssociado daoAssociado = new DAOAssociado(); 
		daoAssociado.removerTodos();
		
		Taxa t1 = new Taxa("Mensalidade", 2021, 120, 12, true, a);
		Taxa t2 = new Taxa("Seguro", 2021, 60, 6, false, a);
		Taxa t3 = new Taxa("Social", 2021, 240, 12, false, a);
		
		controle.adicionar(a);
		controle.adicionar(10, t1);
		controle.adicionar(10, t2);
		controle.adicionar(10, t3);
		
		Associado associadoA = new Associado(1, "Diego", "5519456", 213323, 132156, daoAssociacao.recuperar(10));
		Associado associadoB = new Associado(2, "Carlos", "5519456", 213323, 132156, daoAssociacao.recuperar(10));
		Associado associadoC = new Associado(3, "Vanderlei", "5519456", 213323, 132156, daoAssociacao.recuperar(10));
		controle.adicionar(10, associadoA);
		controle.adicionar(10, associadoB);
		controle.adicionar(10, associadoC);
	
		controle.registrarPagamento(10, t1.getNome(), t1.getVigencia(), associadoA.getNumero(), 51245551, 50);
		controle.registrarPagamento(10, t1.getNome(), t1.getVigencia(), associadoA.getNumero(), 51245551, 40);
		controle.registrarPagamento(10, t1.getNome(), t1.getVigencia(), associadoA.getNumero(), 51245551, 20);
		controle.registrarPagamento(10, t2.getNome(), t2.getVigencia(), associadoB.getNumero(), 51245551, 20);
		controle.registrarPagamento(10, t2.getNome(), t2.getVigencia(), associadoB.getNumero(), 51245551, 20);
		
		Associacao outra = daoAssociacao.recuperar(10);
		Taxa novaTaxa = daoTaxa.recuperar(10, "Mensalidade");
		Taxa naTaxa = daoTaxa.recuperar(10, "Seguro");
		
		assertEquals(3, novaTaxa.getLogPagamentos().size());
		assertEquals(2, naTaxa.getLogPagamentos().size());
		//assertEquals(5, outra.getTaxasAssociados().size());
		
	}
	
	@Test
	public void testarCalculoDePagamento() throws SQLException, ValorInvalido, TaxaNaoExistente, AssociadoJaRemido, AssociacaoJaExistente, AssociacaoNaoExistente, AssociadoJaExistente, AssociadoNaoExistente, TaxaJaExistente, ReuniaoJaExistente, ReuniaoNaoExistente, FrequenciaJaRegistrada, FrequenciaIncompativel {
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
		
		DAOPagamento daoPagamento = new DAOPagamento();
		daoPagamento.removerTodos();
		
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
		
		DAOTaxa daoTaxa = new DAOTaxa();
		daoTaxa.removerTodos();
		
		Taxa taxa1 = new Taxa("Mensalidade", 2021, 120, 12, true, a);
		Taxa taxa2 = new Taxa("Seguro", 2021, 60, 6, false, a);
		Taxa taxa3 = new Taxa("Social", 2021, 240, 12, false, a);
		
		controle.adicionar(10, taxa1);
		controle.adicionar(10, taxa2);
		controle.adicionar(10, taxa3);
		
		controle.registrarPagamento(10, taxa1.getNome(), taxa1.getVigencia(), associadoA.getNumero(), 51245551, 50);
		controle.registrarPagamento(10, taxa1.getNome(), taxa1.getVigencia(), associadoA.getNumero(), 51245551, 40);
		//controle.registrarPagamento(10, taxa1.getNome(), taxa1.getVigencia(), associadoA.getNumero(), 51245551, 20);
		controle.registrarPagamento(10, taxa2.getNome(), taxa2.getVigencia(), associadoB.getNumero(), 51245551, 20);
		controle.registrarPagamento(10, taxa2.getNome(), taxa2.getVigencia(), associadoB.getNumero(), 51245551, 20);
		
		double calculoSoma = controle.somarPagamentoDeAssociado(associadoB.getAssociacao().getNum(), associadoB.getNumero(), taxa2.getNome(), taxa2.getVigencia(), t1.getData(), t3.getData());
		assertEquals(40, calculoSoma);
		
		double calculoTotalDeTaxa = controle.calcularTotalDeTaxas(a.getNum(), taxa1.getVigencia());
		assertEquals(420, calculoTotalDeTaxa);
		
	}
	
	
}
