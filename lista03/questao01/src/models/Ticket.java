package models;

import java.util.Date;

public class Ticket {
	private String placa;
	private Date horarioDeChegada;
	private Date horarioDeSaida;

	public Ticket(String placa, Date horarioDeChegada, Date horarioDeSaida) {
		this.placa = placa;
		this.horarioDeChegada = horarioDeChegada;
		this.horarioDeSaida = horarioDeSaida;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Date getHoraDeChegada() {
		return horarioDeChegada;
	}

	public void setHoraDeChegada(Date horaDeChegada) {
		this.horarioDeChegada = horaDeChegada;
	}

	public Date getHoraDeSaida() {
		return horarioDeSaida;
	}

	public void setHorarioDeSaida(Date horarioDeSaida) {
		this.horarioDeSaida = horarioDeSaida;
	}

	@Override
	public String toString() {
		String ticket = "Placa: " + placa + "\nChegada: " + horarioDeChegada;

		if (horarioDeSaida != null) {
			ticket = ticket + "\nSaida: " + horarioDeSaida;
		}
		return ticket;
	}

}