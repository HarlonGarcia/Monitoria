package models;

import java.util.Date;
import java.util.Objects;

public class Carro {
	private String placa;
	private String modelo;
	private Date dataDeEntrada;
	
	public Carro(String placa, String modelo) {
		this.placa = placa;
		this.modelo = modelo;
	}
	
	public void setarHoraDeEntrada() {
		this.dataDeEntrada = new Date();
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Date getDataDeEntrada() {
		return dataDeEntrada;
	}

	public void setDataDeEntrada(Date dataDeEntrada) {
		this.dataDeEntrada = dataDeEntrada;
	}

	/*
	 * equals comparando o carro pela placa, pois é unica e serve como identificador.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(placa, other.placa);
	}

	@Override
	public String toString() {
		return "Placa: " + placa + " - Modelo: " + modelo;
	}
	
	
}
