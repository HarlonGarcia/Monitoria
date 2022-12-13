package entities;

public class Empresa {
	public static final int MAX_DEPARTAMENTOS = 5;
	private String nome;
	private String cnpj;
	private Departamento[] departamentos;

	public Empresa(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.departamentos = new Departamento[MAX_DEPARTAMENTOS];
	}

	public boolean adicionarDepartamento(Departamento departamento) {
		for (int i = 0; i < MAX_DEPARTAMENTOS; i++) {
			if (departamentos[i] == null) {
				departamentos[i] = departamento;
				return true;
			}
		}
		return false;
	}

	public Departamento pegarDepartamentoPorNome(String nomeDepartamento) {
		for (Departamento departamento : departamentos) {
			if (departamento != null && nomeDepartamento.equals(departamento.getNome())) {
				return departamento;
			}
		}
		return null;
	}

	public boolean transferirFuncionario(String antigoDepartamento, String novoDepartamento, String nomeFuncionario) {
		boolean funcionarioTransferido = false;
		Departamento depAntigo = pegarDepartamentoPorNome(antigoDepartamento);
		Departamento depNovo = pegarDepartamentoPorNome(novoDepartamento);

		if (depAntigo != null && depNovo != null) {
			Funcionario funcionario = depAntigo.pegarFuncionarioPorNome(nomeFuncionario);
			if (funcionario != null) {
				depAntigo.removerFuncionario(funcionario);
				depNovo.adicionarFuncionario(funcionario);
				funcionarioTransferido = true;
			}
		}
		return funcionarioTransferido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Departamento[] getDepartamentos() {
		return departamentos;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Empresa " + nome + "\n");

		for (int i = 0; i < departamentos.length; i++) {
			if (departamentos[i] != null) {
				sb.append(String.format("- %s\n", departamentos[i].getNome()));
			}
		}
		return sb.toString();
	}
}
