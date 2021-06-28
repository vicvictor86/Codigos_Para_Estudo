package victorEmmanuel.associacao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Taxa {

	private String nome;
	private int vigencia;
	private double valorAno;
	private int parcelas;
	private boolean administrativa;

	private ArrayList<LogPagamento> logsPagamentos = new ArrayList<LogPagamento>();

	public Taxa(String nome, int vigencia, double valorAno, int parcelas, boolean administrativa) {
		this.nome = nome;
		this.vigencia = vigencia;
		this.valorAno = valorAno;
		this.parcelas = parcelas;
		this.administrativa = administrativa;
	}

	public double valorMensal() {
		return valorAno / parcelas;
	}

	public String getNome() {
		return nome;
	}

	public int getVigencia() {
		return vigencia;
	}

	public double getValorAno() {
		return valorAno;
	}

	public int getParcelas() {
		return parcelas;
	}

	public boolean isAdministrativa() {
		return administrativa;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}

	public void setValorAno(double valorAno) {
		this.valorAno = valorAno;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public void setAdministrativa(boolean administrativa) {
		this.administrativa = administrativa;
	}

	//verificar quantas parcelas o associado pagou e n deixar ele pagar mais do que a quantidadde
	//de parcelas máximas
	public void pagamento(long data, double valor, Associado associado) throws ValorInvalido, AssociadoJaRemido, TaxaNaoExistente {
		Date date = new Date(data);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		int anoPagamento = cal.get(Calendar.YEAR);
		
		if ((valor < valorMensal() && valor + totalPago(associado) != valorAno) || valor + totalPago(associado) > valorAno || (parcelasPagas(associado) + 1 == parcelas && valor + totalPago(associado) != valorAno)) {
			throw new ValorInvalido();
		}
		
		if(anoPagamento < vigencia) {
			 throw new TaxaNaoExistente();
		}
		
		if (associado instanceof AssociadoRemido){
			if(((AssociadoRemido) associado).getDataRemissao() < data && this.administrativa == true){
				throw new AssociadoJaRemido();				
			}
		}
	
		logsPagamentos.add(new LogPagamento(data, valor, associado));
	}

	public ArrayList<LogPagamento> getLogPagamento() {
		return logsPagamentos;
	}
	
	private double totalPago(Associado associado) {
		double totalPago = 0.0;
		for (LogPagamento logAtual : logsPagamentos) {
			if(associado.getNumero() == logAtual.getAssociado().getNumero()) {
				totalPago += logAtual.getValor();
			}
		}
		return totalPago;
	}
	
	private int parcelasPagas(Associado associado) {
		int parcelasPagas = 0;
		for (LogPagamento logAtual : logsPagamentos) {
			if(associado.getNumero() == logAtual.getAssociado().getNumero()) {
				parcelasPagas++;
			}
		}
		return parcelasPagas;
	}
}
