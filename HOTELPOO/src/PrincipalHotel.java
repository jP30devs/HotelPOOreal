import java.io.IOException;
import java.util.Scanner;

public class PrincipalHotel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reserva reservas = new Reserva();

        while (true) {
            System.out.println("Menu do Sistema de Hotel");
            System.out.println("1. Adicionar Hóspede");
            System.out.println("2. Adicionar Quarto");
            System.out.println("3. Fazer Reserva");
            System.out.println("4. Listar Reservas");
            System.out.println("5. Salvar Reservas em Arquivo");
            System.out.println("6. Ler Reservas de Arquivo");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do hóspede: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do hóspede: ");
                    String cpf = scanner.nextLine();
                    System.out.print("ID do hóspede: ");
                    String id = scanner.nextLine();
                    Hospede hospede = new Hospede(nome, cpf, id);
                    System.out.println("Hóspede adicionado: " + hospede);
                }
                case 2 -> {
                    System.out.print("Número do quarto: ");
                    int numero = scanner.nextInt();
                    System.out.print("Capacidade do quarto: ");
                    int capacidade = scanner.nextInt();
                    Quarto quarto = new Quarto(numero, capacidade);
                    System.out.println("Quarto adicionado: " + quarto);
                }
                case 3 -> {
                    System.out.print("ID do hóspede: ");
                    String idHospede = scanner.nextLine();
                    System.out.print("Número do quarto: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        Quarto quarto = new Quarto(numero, 2);
                        quarto.reservar(idHospede);
                        reservas.adicionarReserva(idHospede, quarto);
                        System.out.println("Reserva realizada com sucesso!");
                    } catch (CapacidadeExcedidaException e) {
                        System.err.println("Erro ao reservar quarto: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.println("Lista de Reservas:");
                    System.out.println(reservas);
                }
                case 5 -> {
                    System.out.print("Nome do arquivo para salvar: ");
                    String nomeArquivo = scanner.nextLine();
                    try {
                        reservas.salvarEmArquivo(nomeArquivo);
                        System.out.println("Reservas salvas com sucesso no arquivo " + nomeArquivo);
                    } catch (IOException e) {
                        System.err.println("Erro ao salvar reservas: " + e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.print("Nome do arquivo para carregar: ");
                    String nomeArquivo = scanner.nextLine();
                    try {
                        reservas.lerDeArquivo(nomeArquivo);
                        System.out.println("Reservas carregadas com sucesso do arquivo " + nomeArquivo);
                    } catch (IOException e) {
                        System.err.println("Erro ao ler reservas: " + e.getMessage());
                    }
                }
                case 7 -> {
                    System.out.println("Encerrando o sistema. Até logo!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}