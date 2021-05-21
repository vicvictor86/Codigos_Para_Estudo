package victorEmmanuelVieira.banco;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteBanco {

	@Test
	public void testarInclusaoDeContaComum() throws ContaInexistente {
		Banco b = new Banco();
		Conta c1 = new ContaComum(1);
		
		b.incluir(c1);
		assertEquals(0, b.saldo(1), 0.001);
	}
	
	@Test
	public void testarInclusaoDeVariasContas() throws ContaInexistente {
		Banco b = new Banco();
		Conta c1 = new ContaComum(1);
		c1.credito(10);
		b.incluir(c1);

		Conta c2 = new ContaComum(2);
		c2.credito(20);
		b.incluir(c2);
		
		Conta c3 = new ContaComum(3);
		c3.credito(30);
		b.incluir(c3);
	
		Conta c4 = new ContaComum(4);
		c4.credito(40);
		b.incluir(c4);
		
		assertEquals(10, b.saldo(1), 0.001);
		assertEquals(20, b.saldo(2), 0.001);
		assertEquals(30, b.saldo(3), 0.001);
		assertEquals(40, b.saldo(4), 0.001);
	}
	
	@Test
	public void testarSaldoDeContaInexistente() throws ContaInexistente {
		Banco b = new Banco();
		Conta c1 = new ContaComum(1);
		c1.credito(99);
		
		b.incluir(c1);
		assertEquals(99, b.saldo(1), 0.001);
	}
	
	@Test
	public void testarExtrato() throws SaldoInsuficiente, ContaInexistente {
		Banco b = new Banco();
		Conta c1 = new ContaComum(1);
		
		b.incluir(c1);
		b.deposito(1, 99);
		b.saque(1, 9);
		assertEquals(90, b.saldo(1), 0.001);
		System.out.println(b.extrato(1));
		assertEquals(" Crédito: 99.0. Saldo: 99.0.\n" + 
				" Débito: 9.0. Saldo: 90.0.\n", b.extrato(1));
	}
	
	@Test
	public void testarSaqueDepositoExtratoContaInexistente() throws SaldoInsuficiente, ContaInexistente {
		Banco b = new Banco();
		Conta c1 = new ContaComum(1);
		
		b.incluir(c1);
		b.deposito(1, 99);
		b.saque(1, 9);
		assertEquals(90, b.saldo(1), 0.001);
		
		try {			
			b.deposito(2, 99);
			b.saque(2, 9);
			assertEquals("", b.extrato(2));
		}catch(ContaInexistente e) {			
			assertEquals(90, b.saldo(1), 0.001);
		}
	}
	
	@Test
	public void testarSaqueAcimaDoSaldoNaoPermitido() throws SaldoInsuficiente, ContaInexistente {
		Banco b = new Banco();
		Conta c1 = new ContaComum(1);
		
		Conta c2 = new Poupanca(2);
		
		b.incluir(c1);
		b.incluir(c2);
		b.deposito(1, 99);
		b.deposito(2, 99);
		b.saque(1, 9);
		b.saque(2, 9);
		assertEquals(90, b.saldo(1), 0.001);
		assertEquals(90, b.saldo(2), 0.001);

		try {
			b.saque(1, 90.1);
			fail("Saque acima do limite sem exceção.");
		} catch (SaldoInsuficiente e) {
			assertEquals(90, b.saldo(1), 0.001);
		}

		try {
			b.saque(2, 90.1);
			fail("Saque acima do limite sem exceção.");
		} catch (SaldoInsuficiente e) {
			assertEquals(90, b.saldo(2), 0.001);
		}
		
	}
	
	@Test
	public void testarSaqueAcimaDoSaldoEmContaEspecial() throws SaldoInsuficiente, ContaInexistente {
		Banco b = new Banco();
		Conta c1 = new ContaEspecial(1, 100);
				
		b.incluir(c1);
		b.deposito(1, 99);
		b.saque(1, 9);
		assertEquals(90, b.saldo(1), 0.001);

		b.saque(1, 90.1);	
		assertEquals(-0.1, b.saldo(1), 0.001);

		try {
			b.saque(1, 100);
			fail("Saque acima do limite da conta especial.");
		} catch (SaldoInsuficiente e) {
			assertEquals(-0.1, b.saldo(1), 0.001);
		}	
}
	
	@Test
	public void testarDepositoSaqueVariasContas() throws SaldoInsuficiente, ContaInexistente {
		Banco b = new Banco();
		Conta c1 = new ContaComum(1);
		b.incluir(c1);

		Conta c2 = new ContaComum(2);
		b.incluir(c2);
		
		Conta c3 = new ContaComum(3);
		b.incluir(c3);
	
		Conta c4 = new ContaComum(4);
		b.incluir(c4);

		b.deposito(1, 11);
		b.deposito(2, 22);
		b.deposito(3, 33);
		b.deposito(4, 44);
		
		assertEquals(11, b.saldo(1), 0.001);
		assertEquals(22, b.saldo(2), 0.001);
		assertEquals(33, b.saldo(3), 0.001);
		assertEquals(44, b.saldo(4), 0.001);
		
		b.saque(1, 1);
		b.saque(2, 2);
		b.saque(3, 3);
		b.saque(4, 4);
		
		assertEquals(10, b.saldo(1), 0.001);
		assertEquals(20, b.saldo(2), 0.001);
		assertEquals(30, b.saldo(3), 0.001);
		assertEquals(40, b.saldo(4), 0.001);
	}
	
	@Test
	public void testarPoupancas() throws SaldoInsuficiente, ContaInexistente, NaoEhPoupanca {
		Banco b = new Banco();
		Conta c1 = new ContaComum(1);
		b.incluir(c1);

		Conta c2 = new Poupanca(2);
		b.incluir(c2);
		
		Conta c3 = new ContaComum(3);
		b.incluir(c3);
	
		Poupanca c4 = new Poupanca(4);
		b.incluir(c4);

		b.deposito(1, 11);
		b.deposito(2, 22);
		b.deposito(3, 33);
		b.deposito(4, 44);
		
		assertEquals(11, b.saldo(1), 0.001);
		assertEquals(22, b.saldo(2), 0.001);
		assertEquals(33, b.saldo(3), 0.001);
		assertEquals(44, b.saldo(4), 0.001);
		
		b.saque(1, 1);
		b.saque(2, 2);
		b.saque(3, 3);
		b.saque(4, 4);
		
		assertEquals(10, b.saldo(1), 0.001);
		assertEquals(20, b.saldo(2), 0.001);
		assertEquals(30, b.saldo(3), 0.001);
		assertEquals(40, b.saldo(4), 0.001);
		
		try {
			b.rendeJuros(1, 0.01);
		}catch(NaoEhPoupanca e) {
			assertEquals(10.0, b.saldo(1), 0.001);
		}
		
		try {
			b.rendeJuros(2, 0.01);
		}catch(NaoEhPoupanca e) {
			assertEquals(20.2, b.saldo(2), 0.001);
		}
		
		try {
			b.rendeJuros(3, 0.01);
		}catch(NaoEhPoupanca e) {
			assertEquals(30.0, b.saldo(3), 0.001);
		}
		
		try {
			b.rendeJuros(4, 0.01);
		}catch(NaoEhPoupanca e) {
			assertEquals(40.4, b.saldo(4), 0.001);
		}
		
		
		
		
		
	}
}
