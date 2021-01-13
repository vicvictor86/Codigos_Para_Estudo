package br.com.bytebank.banco.modelo;

import java.io.Serializable;

/**
 * Classe que representa o cliente do banco
 * 
 * @author Victor
 *
 */


public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	private String profissão;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getProfissão() {
		return profissão;
	}
	
	public void setProfissão(String profissão) {
		this.profissão = profissão;
	}

	public String toString() {
		return this.getNome();
	}
	
}
