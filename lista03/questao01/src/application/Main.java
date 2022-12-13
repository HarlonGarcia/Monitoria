package application;

import java.util.Scanner;

import models.Carro;
import models.Estacionamento;
import models.Ticket;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Estacionamento estacionamento = new Estacionamento();
		
		boolean continuar = true;
		
		do {
			System.out.print("1- Estacionar carro\n2- Ver quantidade de vagas disponiveis\n3- Ver detalhes de algum carro\n4- Tirar carro do estacionamento\n5- Sair\nDigite uma opcao: ");
			int opcao = Integer.parseInt(sc.nextLine());
			
			if (opcao == 1) {
				System.out.print("\nPlaca do carro: ");
				String placa = sc.nextLine().toUpperCase();
				System.out.print("Modelo do carro: ");
				String modelo = sc.nextLine();
	
				Carro carro = new Carro(placa, modelo);
				Ticket ticketDeEntrada = estacionamento.estacionar(carro);
				
				
				if (ticketDeEntrada != null) {
					System.out.println("\n" + ticketDeEntrada + "\n");
				} else {
					System.out.println("\nNao foi possivel estacionar seu carro...tente novamente!\n");
				}
				
			} else if (opcao == 2) {
				int quantidadeDeVagas = estacionamento.verQuantidadeDeVagasDisponiveis();
				System.out.println("\nHa " + quantidadeDeVagas + " vagas\n");
			} else if (opcao == 3) {
				System.out.print("\nDigite a placa do carro para ver detalhes: ");
				String placaDoCarro = sc.nextLine().toUpperCase();
				estacionamento.verDetalhesDeCarro(placaDoCarro);
				System.out.println("\n");
			} else if(opcao == 4) {
				System.out.print("\nDigite a placa do carro para sair do estacionamento: ");
				String placaDoCarro = sc.nextLine().toUpperCase();
				Carro carro = estacionamento.getCarroByPlaca(placaDoCarro);
				
				if (carro != null) {
					double valor = estacionamento.calcularValor(carro.getDataDeEntrada());
					System.out.print("\nO valor do estacionamento foi R$" + valor + ". Por favor, entre com seu pagamento: ");
					double pagamento = Double.parseDouble(sc.nextLine());
					
					boolean estacionamentoPago = estacionamento.pagarEstacionamento(carro.getDataDeEntrada(), pagamento);
					
					if (estacionamentoPago) {
						Ticket ticketDeSaida = estacionamento.sairDoEstacionamento(carro.getPlaca());
						
						if (ticketDeSaida != null) {								
							System.out.println("\nObrigado por confiar no nosso servico!\n\n" + ticketDeSaida + "\n");
						} else {
							System.out.println("\nErro ao resgatar ticket de saida...\n");
						}
					} else {
						System.out.println("\nErro ao realizar pagamento...\n");
					}
				} else {
					System.out.println("\nNao encontramos nenhum carro com esta placa.\n");
				}
			} else if (opcao == 5) {
				continuar = false;
				System.out.print("\nDesconectando...");
			} else {
				System.out.print("\nDigite uma das opcoes acima\n");
			}
		} while (continuar);
		
		
		sc.close();
	}
}
