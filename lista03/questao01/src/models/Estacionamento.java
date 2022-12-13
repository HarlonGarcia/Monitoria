package models;

import java.util.Date;

public class Estacionamento {
	public static final int QUANTIDADE_MAXIMA_VAGAS = 15;
	public static final double PRECO_POR_HORA = 4.0;
	private int vagasOcupadas;
	private Carro[] carros;

	public Estacionamento() {
		this.vagasOcupadas = 0;
		this.carros = new Carro[QUANTIDADE_MAXIMA_VAGAS];
	}


	/*
	 * SESE - Single Entry Single Exit 
	 * Um principio que se trata de ter apenas um retorno por metodo.
	 * 
	 */
	public Ticket estacionar(Carro carro) {
		// Por default deixamos o ticket como null
		// Caso entre no if o ticket vai ser instanciado
		// Por final ele será retornado de qualquer forma, assim evitando dois returns.
		if (carro != null && vagasOcupadas < QUANTIDADE_MAXIMA_VAGAS) {
			for (int i = 0; i < QUANTIDADE_MAXIMA_VAGAS; i++) {
				if (carros[i] == null) {	
					carro.setarHoraDeEntrada();
					carros[i] = carro;
					vagasOcupadas++;
				}

				return new Ticket(carro.getPlaca(), carro.getDataDeEntrada(), null);
			}
		}

		return null;
	}
	

	/*
	 * Por que nao realocar o array?
	 * Se tratando de um estacionamento, optei por deixar os espaços vazios.
	 */
	public Ticket sairDoEstacionamento(String placa) {
		Ticket ticketDeSaida = null;
		int vagaEstacionada = acharCarroPelaPlaca(placa);
		
		if (vagaEstacionada >= 0) {
			Carro carro = carros[vagaEstacionada];
			carros[vagaEstacionada] = null;
			ticketDeSaida = new Ticket(carro.getPlaca(), carro.getDataDeEntrada(), new Date());
			vagasOcupadas--;
		}
		
		return ticketDeSaida;
	}

	public boolean pagarEstacionamento(Date horaDeEntrada, Double pagamento) {
		boolean estacionamentoPago = false;
		double valor = calcularValor(horaDeEntrada);

		if (valor <= pagamento) {
			estacionamentoPago = true;
		}
		
		return estacionamentoPago;
	}

	public double calcularValor(Date entrada) {
		Date horarioDeSaida = new Date();
		long horas = calcularDiferencaDeHorario(entrada, horarioDeSaida);
		
		if (horas == 0) {
			horas = 1;
		}
		
		return horas * PRECO_POR_HORA;
	}

	public long calcularDiferencaDeHorario(Date entrada, Date saida) {
		long diferencaEmMilissegundos = Math.abs(saida.getTime() - entrada.getTime());
		long diferencaEmHoras = (diferencaEmMilissegundos / (60 * 60 * 1000)) % 24;

		return diferencaEmHoras;
	}

	public int acharCarroPelaPlaca(String placa) {
		for (int i = 0; i < vagasOcupadas; i++) {
			if (carros[i] != null && carros[i].getPlaca().equals(placa)) {
				return i;
			}
		}
		return -1;
	}
	
	public Carro getCarroByPlaca(String placa) {
		int vagaDoCarro = acharCarroPelaPlaca(placa);
		
		if (vagaDoCarro >= 0) {
			return carros[vagaDoCarro];
		}
		return null;
	}
	
	public void verDetalhesDeCarro(String placa) {
		int vagaEstacionada = acharCarroPelaPlaca(placa);
		
		if (vagaEstacionada >= 0) {			
			System.out.print(carros[vagaEstacionada]);
		} else {
			System.out.print("Nao ha nenhum carro com esta placa.");
		}
	}
	
	public int verQuantidadeDeVagasDisponiveis() {
		return QUANTIDADE_MAXIMA_VAGAS - vagasOcupadas;
	}
}