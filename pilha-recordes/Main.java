import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Tamanho inicial da pilha: ");
        int tamanho = Integer.parseInt(scanner.nextLine());

        PilhaRecordes pilha = new PilhaRecordes(tamanho);

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\nMENU");
            System.out.println("1 - Inserir recorde");
            System.out.println("2 - Ver recorde atual");
            System.out.println("3 - Remover recorde");
            System.out.println("4 - Listar recordes");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Digite um número válido!");
                continue;
            }

            switch (opcao) {

                case 1:

                    System.out.print("Nome do atleta: ");
                    String nome = scanner.nextLine();

                    double tempo = 0;

                    while (true) {
                        try {
                            System.out.print("Tempo: ");
                            String tempoStr = scanner.nextLine().replace(",", ".");
                            tempo = Double.parseDouble(tempoStr);
                            break;
                        } catch (Exception e) {
                            System.out.println("Tempo inválido! Digite novamente.");
                        }
                    }

                    LocalDate data = null;

                    while (true) {
                        try {
                            System.out.print("Data (AAAA-MM-DD): ");
                            String dataStr = scanner.nextLine();
                            data = LocalDate.parse(dataStr);
                            break;
                        } catch (Exception e) {
                            System.out.println("Data inválida! Use formato AAAA-MM-DD.");
                        }
                    }

                    Recorde r = new Recorde(data, tempo, nome);

                    if (pilha.push(r)) {
                        System.out.println("Recorde inserido!");
                    }

                    break;

                case 2:

                    Recorde topo = pilha.peek();

                    if (topo == null) {
                        System.out.println("Pilha vazia.");
                    } else {
                        System.out.println("Recorde atual:");
                        System.out.println(topo);
                    }

                    break;

                case 3:

                    Recorde removido = pilha.pop();

                    if (removido != null) {
                        System.out.println("Removido: " + removido);
                    }

                    break;

                case 4:

                    pilha.listar();
                    break;

                case 0:

                    System.out.println("Encerrando...");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}