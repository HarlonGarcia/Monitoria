package application;

import java.util.Scanner;
import entities.Departamento;
import entities.Empresa;
import entities.Funcionario;

public class Main {

	public static void main(String[] args) {
		boolean continuar = true;
		Scanner sc = new Scanner(System.in);
		Empresa empresa = new Empresa("Monitoria Java", "1234");

		do {
			System.out.print(getMenu());
			int opcao = Integer.parseInt(sc.nextLine());

			if (opcao == 1) {
				System.out.print("\n" + empresa);
			} else if (opcao == 2) {
				System.out.print("\nDigite o nome do departamento a ser criado: ");
				String nome = sc.nextLine();
				Departamento departamento = new Departamento(nome);
				boolean departamentoCriado = empresa.adicionarDepartamento(departamento);
				
				if (departamentoCriado) {
					System.out.print("Departamento " + nome + " criado com sucesso.\n");
				} else {
					System.out.print("Erro ao criar departamento...tente novamente.\n");
				}
			} else if (opcao == 3) {
				System.out.print("\n" + empresa + "\nDigite o nome do departamento: ");
				String nomeDepartamento = sc.nextLine();
				Departamento departamento = empresa.pegarDepartamentoPorNome(nomeDepartamento);
				
				if (departamento != null) {
					System.out.print(getMenuDepartamento());
					int opcaoDepartamento = Integer.parseInt(sc.nextLine());
					
					switch (opcaoDepartamento) {
					case 1:
						System.out.print("\n" + departamento);
						break;
					case 2:
						System.out.print("\nDigite o nome do funcionario: ");
						String nome = sc.nextLine();
						System.out.print("Digite o salario do funcionario: ");
						double salario = Double.parseDouble(sc.nextLine());
						
						Funcionario novoFuncionario = new Funcionario(nome, salario);
						boolean funcionarioAdicionado = departamento.adicionarFuncionario(novoFuncionario);
						
						if (funcionarioAdicionado) {
							System.out.print("\nFuncionario " + nome + " cadastrado com sucesso.\n");
						} else {
							System.out.print("\nErro ao adicionar funcionario...tente novamente.\n");
						}
						break;
					case 3:
						System.out.print("\n" + empresa);
						System.out.print("\nQual sera o novo departamento do funcionario? ");
						String departamentoNovo = sc.nextLine();
						System.out.print("Digite o nome do funcionario: ");
						String nomeFunc = sc.nextLine();
						boolean funcionarioTransferido = empresa.transferirFuncionario(nomeDepartamento, departamentoNovo, nomeFunc);
						
						if (funcionarioTransferido) {
							System.out.print("\nFuncionario " + nomeFunc + " transferido com sucesso.\n");
						} else {
							System.out.print("\nErro ao transferir funcionario...tente novamente.\n");
						}
						break;
					case 4:
						System.out.print("\nDigite o nome do funcionario: ");
						String nomeFuncionario = sc.nextLine();
						Funcionario funcionario = departamento.pegarFuncionarioPorNome(nomeFuncionario);
						
						if (funcionario != null) {
							funcionario.concederAumento();
							System.out.print("\nAumento concedido com sucesso.\n");
						} else {
							System.out.print("\nFuncionario nao encontrado...tente novamente.\n");
						}
						break;
					case 5:
						break;
					default:
						System.out.print("\nDigite uma opcao valida.\n");
					}
				} else {
					System.out.print("\nDepartamento nao encontrado...tente novamente.\n");
				}
				
			} else if (opcao == 4) {
				System.out.print("\nDesconectando...\n");
				continuar = false;
			} else {
				System.out.print("\nDigite uma opcao valida.\n");
			}
		} while (continuar);

	}

	public static String getMenu() {
		return "\nBEM VINDO\n" + "1- Listar departamentos\n" + "2- Criar departamento\n"
				+ "3- Ver funcionarios\n" + "4- Sair\n" + "Digite umas das opcoes (1/4): ";
	}

	public static String getMenuDepartamento() {
		return "\nMENU DEPARTAMENTO\n" + "1- Listar funcionarios por departamento\n" + "2- Cadastrar funcionario\n"
				+ "3- Transferir funcionario\n" + "4- Conceder aumento para funcionario\n" + "5- Sair\n"
				+ "Digite uma das opcoes (1/5): ";
	}
}
