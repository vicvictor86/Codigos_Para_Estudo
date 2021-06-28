package victorEmmanuel.associacao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class TesteVictor {

	@Test
	public void testarCadastroDeAssociacao() throws AssociacaoJaExistente, ValorInvalido {
		InterfaceAssociacao controle = new MinhaAssociacao();
		Associacao a1 = new Associacao(1306, "");

		// Tentativa de cadastrar com sem nome
		try {
			controle.adicionar(a1);
			fail("Deveria ter dado erro!");
		} catch (ValorInvalido e) {
			// Ok. Era pra dar erro mesmo!
		}

		a1.setNome("Cruzeiro do Sul V");
		controle.adicionar(a1);

		try {
			controle.adicionar(a1);
			fail("Deveria ter dado erro!");
		} catch (AssociacaoJaExistente e) {
			// Ok, era pra dar erro mesmo!
		}

		try {
			Associacao a2 = new Associacao(-100, "dawawdd");
			controle.adicionar(a2);
		} catch (ValorInvalido e) {
			// Número negativo
		}

	}

	@Test
	public void testarCadastroDeAssociado()
			throws AssociacaoJaExistente, ValorInvalido, AssociacaoNaoExistente, AssociadoJaExistente {
		InterfaceAssociacao controle = new MinhaAssociacao();
		Associacao a1 = new Associacao(1306, "Cruzeiro do Sul V");
		controle.adicionar(a1);
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(1974, 10, 14);
		long nasc = gc.getTimeInMillis();
		Date hoje = new Date();
		Associado associado1 = new Associado(1, "Pedro", "3232-3232", hoje.getTime(), nasc);
		controle.adicionar(1306, associado1);
		try {
			controle.adicionar(1306, associado1);
			fail("Era pra ter dado erro!");
		} catch (AssociadoJaExistente e) {
			// Ok, era pra ter dado erro!
		}

		try {
			Associado associado2 = new Associado(-1, "Pedr", "3232-3232", hoje.getTime(), nasc);
			controle.adicionar(1306, associado2);
		} catch (ValorInvalido e) {
			// Numero negativo
		}

		try {
			Associado associado3 = new Associado(2, "", "3232-3232", hoje.getTime(), nasc);
			controle.adicionar(1306, associado3);
		} catch (ValorInvalido e) {
			// String vazia
		}

	}

	@Test
	public void testarCadastroDeReuniao()
			throws AssociacaoNaoExistente, ValorInvalido, ReuniaoJaExistente, AssociacaoJaExistente {
		InterfaceAssociacao controle = new MinhaAssociacao();
		Associacao a1 = new Associacao(1306, "Cruzeiro do Sul V");
		controle.adicionar(a1);
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(2021, 01, 01);
		long dataReuni = gc.getTimeInMillis();

		Reuniao reuniao1 = new Reuniao(dataReuni, "Aumento de taxas");
		controle.adicionar(1306, reuniao1);
		try {
			controle.adicionar(1306, reuniao1);
			fail("Era pra ter dado erro!");
		} catch (ReuniaoJaExistente e) {
			// Ok, era pra ter dado erro!
		}

		try {
			Reuniao reuniao2 = new Reuniao(-1, "Aumento de taixa");
			controle.adicionar(1306, reuniao2);
		} catch (ValorInvalido e) {
			// numero negativo
		}

		try {
			Reuniao reuniao2 = new Reuniao(515151, "");
			controle.adicionar(1306, reuniao2);
		} catch (ValorInvalido e) {
			// ata vazia
		}

	}

	@Test
	public void testarCadastroDeTaxa()
			throws AssociacaoNaoExistente, AssociacaoJaExistente, ValorInvalido, TaxaJaExistente {
		InterfaceAssociacao controle = new MinhaAssociacao();
		Associacao a1 = new Associacao(1306, "Cruzeiro do Sul V");
		controle.adicionar(a1);
		Taxa taxa1 = new Taxa("Manutencao", 2021, 600, 12, true);
		controle.adicionar(1306, taxa1);
		try {
			controle.adicionar(1306, taxa1);
			fail("Era pra ter dado erro!");
		} catch (TaxaJaExistente e) {
			// Ok, era pra ter dado erro!
		}
	}

	@Test
	public void testarCalculoDeFrequencia() throws Exception {
		InterfaceAssociacao controle = new MinhaAssociacao();
		Associacao a1 = new Associacao(1306, "Cruzeiro do Sul V");
		controle.adicionar(a1);

		GregorianCalendar gc = new GregorianCalendar();
		gc.set(1974, 10, 14);
		long nasc = gc.getTimeInMillis();
		gc.set(2021, 01, 01);
		long data1 = gc.getTimeInMillis();
		Associado associado1 = new Associado(1, "Pedro", "3232-3232", data1, nasc);
		controle.adicionar(1306, associado1);
		Associado associado2 = new Associado(2, "Pedra", "3232-3232", data1 + 10000, nasc);
		controle.adicionar(1306, associado2);

		Reuniao reuniao1 = new Reuniao(data1, "Aumento de taxas");
		controle.adicionar(1306, reuniao1);
		controle.registrarFrequencia(1, 1306, data1);

		Reuniao reuniao2 = new Reuniao(data1 + 1000000, "Confirmacao de aumento");
		controle.adicionar(1306, reuniao2);

		double freq = controle.calcularFrequencia(1, 1306, data1, data1 + 1000000);
		assertEquals(0.5, freq, 0.01);

		try {
			controle.calcularFrequencia(152, 1306, data1, data1 + 1000000);
		} catch (AssociadoNaoExistente e) {
			// associado não existente
		}

		try {
			controle.calcularFrequencia(1, 1305, data1, data1 + 1000000);
		} catch (AssociacaoNaoExistente e) {
			// associacao não existente
		}

		try {
			controle.registrarFrequencia(1, 1306, data1);
		} catch (FrequenciaJaRegistrada e) {
			// Erro
		}

		try {
			controle.registrarFrequencia(2, 1306, data1);
		} catch (FrequenciaIncompativel e) {
			// Erro
		}

	}

	@Test
	public void testarPagamento() throws AssociacaoNaoExistente, AssociadoNaoExistente, TaxaNaoExistente,
			AssociacaoJaExistente, ValorInvalido, AssociadoJaExistente, TaxaJaExistente, AssociadoJaRemido {
		InterfaceAssociacao controle = new MinhaAssociacao();
		Associacao a1 = new Associacao(1306, "Cruzeiro do Sul V");
		controle.adicionar(a1);

		GregorianCalendar gc = new GregorianCalendar();
		gc.set(1974, 10, 14);
		long nasc = gc.getTimeInMillis();
		gc.set(2021, 01, 01);
		long data1 = gc.getTimeInMillis();
		Associado associado1 = new Associado(1, "Pedro", "3232-3232", data1, nasc);
		controle.adicionar(1306, associado1);

		// Remissão em 01/03/2021
		gc.set(2021, 02, 01);
		long remissao = gc.getTimeInMillis();
		Associado associado2 = new AssociadoRemido(2, "Raimundo", "3232-3232", data1, nasc, remissao);
		controle.adicionar(1306, associado2);

		Taxa taxa1 = new Taxa("Manutencao", 2021, 600, 12, true);
		controle.adicionar(1306, taxa1);

		Taxa taxa2 = new Taxa("Reforma", 2021, 1200, 12, false);
		controle.adicionar(1306, taxa2);

		GregorianCalendar calendarioGroriano = new GregorianCalendar();
		calendarioGroriano.set(2019, 06, 12);
		long dataPassado = calendarioGroriano.getTimeInMillis();

		try {
			controle.registrarPagamento(1306, "Reforma", 2021, 1, dataPassado, 200);
		} catch (TaxaNaoExistente e) {
			// Dar erro pois no momento que pagou a taxa ela ainda n existia
		}

		Date hoje = new Date();

		try {
			controle.registrarPagamento(1306, "Manutencao", 2021, 1, hoje.getTime(), 49);
			fail("Nao deveria deixar pagar esse valor");
		} catch (ValorInvalido e) {
			// Ok. Barrou pagamento abaixo da parcela!
		}
		controle.registrarPagamento(1306, "Manutencao", 2021, 1, hoje.getTime(), 60);
		controle.registrarPagamento(1306, "Reforma", 2021, 1, hoje.getTime(), 100);

		double valor = controle.somarPagamentoDeAssociado(1306, 1, "Manutencao", 2021, hoje.getTime(), hoje.getTime());
		assertEquals(60, valor, 0.01);
		double valor2 = controle.somarPagamentoDeAssociado(1306, 1, "Reforma", 2021, hoje.getTime(), hoje.getTime());
		assertEquals(100, valor2, 0.01);

		try {
			controle.registrarPagamento(1306, "Manutencao", 2021, 2, hoje.getTime(), 60);
			fail("Nao deveria deixar pagar esse valor");
		} catch (AssociadoJaRemido e) {
			// Ok. Barrou pagamento de taxa adminsitrativa!
		}

		controle.registrarPagamento(1306, "Reforma", 2021, 2, hoje.getTime(), 100);
		valor = controle.somarPagamentoDeAssociado(1306, 2, "Manutencao", 2021, hoje.getTime(), hoje.getTime());
		assertEquals(0, valor, 0.01);
		valor2 = controle.somarPagamentoDeAssociado(1306, 2, "Reforma", 2021, hoje.getTime(), hoje.getTime());
		assertEquals(100, valor2, 0.01);
		controle.registrarPagamento(1306, "Reforma", 2021, 2, hoje.getTime(), 1080);
		valor2 = controle.somarPagamentoDeAssociado(1306, 2, "Reforma", 2021, hoje.getTime(), hoje.getTime());
		assertEquals(1180, valor2, 0.01);
		controle.registrarPagamento(1306, "Reforma", 2021, 2, hoje.getTime(), 20);
		valor2 = controle.somarPagamentoDeAssociado(1306, 2, "Reforma", 2021, hoje.getTime(), hoje.getTime());
		assertEquals(1200, valor2, 0.01);
	}

	@Test
	public void testaParcelas() throws AssociacaoNaoExistente, AssociadoNaoExistente, TaxaNaoExistente,
			AssociacaoJaExistente, ValorInvalido, AssociadoJaExistente, TaxaJaExistente, AssociadoJaRemido {
		InterfaceAssociacao controle = new MinhaAssociacao();
		Associacao a1 = new Associacao(1306, "Cruzeiro do Sul V");
		controle.adicionar(a1);

		GregorianCalendar gc = new GregorianCalendar();
		gc.set(1974, 10, 14);
		long nasc = gc.getTimeInMillis();
		gc.set(2021, 01, 01);
		long data1 = gc.getTimeInMillis();
		Associado associado1 = new Associado(1, "Pedro", "3232-3232", data1, nasc);
		controle.adicionar(1306, associado1);

		// Remissão em 01/03/2021
		gc.set(2021, 02, 01);
		long remissao = gc.getTimeInMillis();
		Associado associado2 = new AssociadoRemido(2, "Raimundo", "3232-3232", data1, nasc, remissao);
		controle.adicionar(1306, associado2);

		Taxa taxa1 = new Taxa("Manutencao", 2021, 600, 12, true);
		controle.adicionar(1306, taxa1);

		Taxa taxa2 = new Taxa("Reforma", 2021, 1200, 12, false);
		controle.adicionar(1306, taxa2);

		GregorianCalendar calendarioGroriano = new GregorianCalendar();
		calendarioGroriano.set(2019, 06, 12);
		long dataPassado = calendarioGroriano.getTimeInMillis();

		try {
			controle.registrarPagamento(1306, "Reforma", 2021, 1, dataPassado, 200);
		} catch (TaxaNaoExistente e) {
			// Dar erro pois no momento que pagou a taxa ela ainda n existia
		}

		Date hoje = new Date();

		try {
			controle.registrarPagamento(1306, "Manutencao", 2021, 1, hoje.getTime(), 49);
			fail("Nao deveria deixar pagar esse valor");
		} catch (ValorInvalido e) {
			// Ok. Barrou pagamento abaixo da parcela!
		}
		controle.registrarPagamento(1306, "Manutencao", 2021, 1, hoje.getTime(), 60);
		controle.registrarPagamento(1306, "Reforma", 2021, 1, hoje.getTime(), 100);

		double valor = controle.somarPagamentoDeAssociado(1306, 1, "Manutencao", 2021, hoje.getTime(), hoje.getTime());
		assertEquals(60, valor, 0.01);
		double valor2 = controle.somarPagamentoDeAssociado(1306, 1, "Reforma", 2021, hoje.getTime(), hoje.getTime());
		assertEquals(100, valor2, 0.01);

		try {
			controle.registrarPagamento(1306, "Manutencao", 2021, 2, hoje.getTime(), 60);
			fail("Nao deveria deixar pagar esse valor");
		} catch (AssociadoJaRemido e) {
			// Ok. Barrou pagamento de taxa adminsitrativa!
		}

		controle.registrarPagamento(1306, "Reforma", 2021, 2, hoje.getTime(), 100);
		valor = controle.somarPagamentoDeAssociado(1306, 2, "Manutencao", 2021, hoje.getTime(), hoje.getTime());
		assertEquals(0, valor, 0.01);
		valor2 = controle.somarPagamentoDeAssociado(1306, 2, "Reforma", 2021, hoje.getTime(), hoje.getTime());
		assertEquals(100, valor2, 0.01);
		controle.registrarPagamento(1306, "Reforma", 2021, 2, hoje.getTime(), 1080);
		valor2 = controle.somarPagamentoDeAssociado(1306, 2, "Reforma", 2021, hoje.getTime(), hoje.getTime());
		assertEquals(1180, valor2, 0.01);
		controle.registrarPagamento(1306, "Reforma", 2021, 2, hoje.getTime(), 20);
		valor2 = controle.somarPagamentoDeAssociado(1306, 2, "Reforma", 2021, hoje.getTime(), hoje.getTime());
		assertEquals(1200, valor2, 0.01);

		try {
			controle.calcularTotalDeTaxas(1306, 2020);
		} catch (TaxaNaoExistente e) {
			// Erro
		}

		double valorDasTaxas = controle.calcularTotalDeTaxas(1306, 2021);
		assertEquals(1800, valorDasTaxas, 0.01);
	}
}
