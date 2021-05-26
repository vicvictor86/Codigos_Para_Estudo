import java.util.ArrayList;

public class MinhaLocadora implements Locadora {

	private double faturamentoMoto;
	private double faturamentoCarro;
	private double faturamentoOnibus;
	private double faturamentoCaminhao;

	public ArrayList<Veiculo> repositorioDeVeiculos = new ArrayList<Veiculo>();
	public ArrayList<Cliente> repositorioDeCliente = new ArrayList<Cliente>();

	public void inserir(Veiculo veiculo) throws VeiculoJaCadastrado {
		try {
			Veiculo jaExiste = pesquisar(veiculo.getPlaca());
			// Possivelmente n precisa do if
			if (jaExiste != null) {
				throw new VeiculoJaCadastrado();
			}
		} catch (VeiculoNaoCadastrado e) {
			repositorioDeVeiculos.add(veiculo);
		}
	}

	public void inserir(Cliente cliente) throws ClienteJaCadastrado {
		Cliente jaExiste = pesquisarCliente(cliente.getCpf());
		if (jaExiste != null) {
			throw new ClienteJaCadastrado();
		}

		repositorioDeCliente.add(cliente);
	}

	public Veiculo pesquisar(String placa) throws VeiculoNaoCadastrado {
		for (Veiculo veiculoLista : repositorioDeVeiculos) {
			if (veiculoLista.getPlaca().equals(placa)) {
				return veiculoLista;
			}
		}
		throw new VeiculoNaoCadastrado();
	}

	public Cliente pesquisarCliente(int cpf) {
		for (Cliente cliente : repositorioDeCliente) {
			if (cliente.getCpf() == cpf) {
				return cliente;
			}
		}
		return null;
	}

	public ArrayList<Veiculo> pesquisarMoto(int cilindrada) {

		ArrayList<Veiculo> motos = new ArrayList<Veiculo>();
		for (Veiculo veiculoLista : repositorioDeVeiculos) {
			if (veiculoLista instanceof Moto && cilindrada == ((Moto) veiculoLista).getCilindradas()) {
				motos.add(veiculoLista);
			}
		}

		return motos;
	}

	public ArrayList<Veiculo> pesquisarCarro(int tipoCarro) {

		ArrayList<Veiculo> carros = new ArrayList<Veiculo>();
		for (Veiculo veiculoLista : repositorioDeVeiculos) {
			if (veiculoLista instanceof Carro && tipoCarro == ((Carro) veiculoLista).getCategoria()) {
				carros.add(veiculoLista);
			}
		}

		return carros;
	}

	public ArrayList<Veiculo> pesquisarCaminhao(int carga) {

		ArrayList<Veiculo> caminhoes = new ArrayList<Veiculo>();
		for (Veiculo veiculoLista : repositorioDeVeiculos) {
			if (veiculoLista instanceof Caminhao && carga == ((Caminhao) veiculoLista).getCapacidadeDeCarga()) {
				caminhoes.add(veiculoLista);
			}
		}

		return caminhoes;
	}

	public ArrayList<Veiculo> pesquisarOnibus(int passageiros) {

		ArrayList<Veiculo> onibus = new ArrayList<Veiculo>();
		for (Veiculo veiculoLista : repositorioDeVeiculos) {
			if (veiculoLista instanceof Onibus && passageiros == ((Onibus) veiculoLista).getPassageiros()) {
				onibus.add(veiculoLista);
			}
		}

		return onibus;
	}

	public double calcularAluguel(String placa, int dias) throws VeiculoNaoCadastrado {
		Veiculo atual = pesquisar(placa);
		return atual.aluguel(dias);
	}

	public void registrarAluguel(String placa, int dias, Cliente cliente) throws VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado {
		double precoAluguel = calcularAluguel(placa, dias);
		
		for (Cliente clienteLista : repositorioDeCliente) {
			if(clienteLista.getCpf() == cliente.getCpf()) {
				
				Veiculo atual = pesquisar(placa);
				
				if (atual.isAlugado()) {
					throw new VeiculoAlugado();
				} else {
					atual.setClienteAlugou(cliente);
					atual.setPrecoAluguel(precoAluguel);
					
					registrarEspecifico(cliente, atual);
					
					atual.alugar();
				}
				return;
			}
		}
		throw new ClienteNaoCadastrado();
	}

	private void devolucao(Veiculo atual) {
		atual.setPrecoAluguel(0.0);
		atual.devolver();
	}

	private void registrarEspecifico(Cliente cliente, Veiculo atual) {
		if (atual instanceof Moto) {
			faturamentoMoto += atual.getPrecoAluguel();
			devolucao(atual);
		} else if (atual instanceof Carro) {
			faturamentoCarro += atual.getPrecoAluguel();
			devolucao(atual);
		} else if (atual instanceof Onibus) {
			faturamentoOnibus += atual.getPrecoAluguel();
			devolucao(atual);
		} else if (atual instanceof Caminhao) {
			faturamentoCaminhao += atual.getPrecoAluguel();
			devolucao(atual);
		}
	}

	public void registrarDevolucao(String placa, Cliente cliente)
			throws VeiculoNaoCadastrado, VeiculoNaoAlugado, ClienteNaoCadastrado {
		Veiculo atual = pesquisar(placa);
		if (atual.isAlugado()) {
			for (Cliente clienteLista : repositorioDeCliente) {
				if (clienteLista.getCpf() == cliente.getCpf()) {
					if (atual.getClienteAlugou().getCpf() == cliente.getCpf()) {
						//registrarEspecifico(cliente, atual); Não precisa mais devolver o veículo para contar no faturamento
						devolucao(atual);
						return;
					}
				}
			}
			throw new ClienteNaoCadastrado();
		} else {
			throw new VeiculoNaoAlugado();
		}
	}

	private void depreciarEspecifico(Class tipoVeiculo, double taxaDeDepreciacao) {
		for (Veiculo veiculoLista : repositorioDeVeiculos) {
			if (tipoVeiculo.isInstance(veiculoLista)) {
				veiculoLista.depreciarVeiculo(taxaDeDepreciacao);
			}
		}
	}

	public void depreciarVeiculos(int tipo, double taxaDeDepreciacao) {
		switch (tipo) {
		case 0:
			depreciarEspecifico(Veiculo.class, taxaDeDepreciacao);
			break;
		case 1:
			depreciarEspecifico(Moto.class, taxaDeDepreciacao);
			break;
		case 2:
			depreciarEspecifico(Carro.class, taxaDeDepreciacao);
			break;
		case 3:
			depreciarEspecifico(Caminhao.class, taxaDeDepreciacao);
			break;
		case 4:
			depreciarEspecifico(Onibus.class, taxaDeDepreciacao);
			break;
		default:
			break;
		}
	}

	private void aumentarEspecifico(Class tipoVeiculo, double taxaAumento) {
		for (Veiculo veiculoLista : repositorioDeVeiculos) {
			if (tipoVeiculo.isInstance(veiculoLista)) {
				if(veiculoLista instanceof Caminhao) {
					System.out.println("Subiu caminhao");
				}
				veiculoLista.aumentarDiaria(taxaAumento);
			}
		}
	}

	public void aumentarDiaria(int tipo, double taxaAumento) {
		switch (tipo) {
		case 0:
			aumentarEspecifico(Veiculo.class, taxaAumento);
			break;
		case 1:
			aumentarEspecifico(Moto.class, taxaAumento);
			break;
		case 2:
			aumentarEspecifico(Carro.class, taxaAumento);
			break;
		case 3:
			aumentarEspecifico(Caminhao.class, taxaAumento);
			break;
		case 4:
			aumentarEspecifico(Onibus.class, taxaAumento);
			break;
		default:
			break;
		}
	}

	public double faturamentoTotal(int tipo) {

		switch (tipo) {
		case 0:
			return (faturamentoCaminhao + faturamentoMoto + faturamentoOnibus + faturamentoCarro);
		case 1:
			return (faturamentoMoto);
		case 2:
			return (faturamentoCarro);
		case 3:
			return (faturamentoCaminhao);
		case 4:
			return (faturamentoOnibus);
		default:
			return 0;
		}
	}

	private int quantidadeDeCadaVeiculo(Class tipoVeiculo) {
		int quantidadeDeDiarias = 0;
		for (Veiculo veiculoLista : repositorioDeVeiculos) {
			if (tipoVeiculo.isInstance(veiculoLista)) {
				quantidadeDeDiarias += veiculoLista.getQuantidadeAlugueisFechados();
			}
		}

		return quantidadeDeDiarias;
	}

	public int quantidadeTotalDeDiarias(int tipo) {
		switch (tipo) {
		case 0:
			return quantidadeDeCadaVeiculo(Veiculo.class);
		case 1:
			return quantidadeDeCadaVeiculo(Moto.class);
		case 2:
			return quantidadeDeCadaVeiculo(Carro.class);
		case 3:
			return quantidadeDeCadaVeiculo(Caminhao.class);
		case 4:
			return quantidadeDeCadaVeiculo(Onibus.class);
		default:
			return 0;
		}
	}
}
