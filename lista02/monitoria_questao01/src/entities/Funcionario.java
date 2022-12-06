package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Funcionario {
	private String nome;
	private double salario;
	private Date dataAdmissao;

	public Funcionario(String nome, double salario) {
		this.nome = nome;
		this.salario = salario;
		this.dataAdmissao = new Date();
	}

	public String getDataFormatada() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return sdf.format(dataAdmissao);
	}
	
	public void concederAumento() {
		this.salario *= 1.1;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	@Override
	public String toString() {
		return String.format("Nome: %s\nSalario: R$%.2f\nAdmissao: %s\n", nome, salario, getDataFormatada());
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataAdmissao, nome, salario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(nome, other.nome);
	}
}
