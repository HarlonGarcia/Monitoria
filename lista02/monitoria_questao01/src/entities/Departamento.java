package entities;

public class Departamento {
	public static final int MAX_FUNCIONARIOS = 50;
	private String nome;
	private Funcionario[] funcionarios;

	public Departamento(String nome) {
		this.nome = nome;
		this.funcionarios = new Funcionario[MAX_FUNCIONARIOS];
	}

	public boolean adicionarFuncionario(Funcionario funcionario) {
		for (int i = 0; i < MAX_FUNCIONARIOS; i++) {
			if (funcionarios[i] == null) {
				funcionarios[i] = funcionario;
				return true;
			}
		}
		return false;
	}
	
	public boolean removerFuncionario(Funcionario funcionario) {
		for (int i = 0; i < MAX_FUNCIONARIOS; i++) {
			if (funcionarios[i] != null && funcionario.equals(funcionarios[i])) {
				funcionarios[i] = null;
				realocarArray();
				return true;
			}
		}
		return false;
	}
	
	public void realocarArray() {
		Funcionario[] novoArray = new Funcionario[MAX_FUNCIONARIOS];
		int inseridos = 0;
		
		for (int i = 0; i < MAX_FUNCIONARIOS; i++) {
			if (funcionarios[i] != null) {
				novoArray[inseridos] = funcionarios[i];
				inseridos++;
			}
		}
		funcionarios = novoArray;
	}
	
	
	public Funcionario pegarFuncionarioPorNome(String nomeFuncionario) {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario != null && nomeFuncionario.equals(funcionario.getNome())) {
				return funcionario;
			}
		}
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Funcionario[] getFuncionarios() {
		return funcionarios;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Departamento " + nome + "\n");
		for (int i = 0; i < MAX_FUNCIONARIOS; i++) {
			if (funcionarios[i] != null) {
				sb.append(String.format("%d -\nNome: %s\nSalario: R$%.2f\nAdmissao: %s\n", i + 1,
						funcionarios[i].getNome(), funcionarios[i].getSalario(), funcionarios[i].getDataFormatada()));
			}
		}
		return sb.toString();
	}
}
