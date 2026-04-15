import java.util.Scanner;

public class App {

    static Scanner leia = new Scanner(System.in);

    private static int menu() {
        System.out.println("\n--- Menu Pilha ---");
        System.out.println("1. Inserir elemento - Push");
        System.out.println("2. Remover elemento - Pop");
        System.out.println("3. Mostrar topo - Peek");
        System.out.println("4. Mostrar pilha");
        System.out.println("0. Sair");
        System.out.printf("Digite a opção desejada: ");
        return leia.nextInt();
    }

    public static void main(String[] args) throws Exception {
        // Pilha agr ta sem limite de tamanho
        Pilha<Processo> minhaPilha = new Pilha<>();
        int opcao = 0;
        Processo elemento;
        
        do { 
            opcao = menu();
            switch(opcao) {
                case 1: 
                    System.out.println("Entre com uma string para inserir na pilha:");
                    leia.nextLine(); 
                    String descricao = leia.nextLine();
                    System.out.println("Entre com o tempo:");
                    double tempo = leia.nextDouble();
                    elemento = new Processo(descricao, tempo);
                    
                    if(minhaPilha.push(elemento)) 
                        System.out.println("Dado inserido!");
                    else
                        System.out.println("Pilha cheia");
                    break;
                    
                case 2:
                    Processo removido = minhaPilha.pop();
                    if(removido != null) 
                        System.out.println("Removido: " + removido);
                    else 
                        System.out.println("A pilha está vazia!");
                    break;
                    
                case 3:
                    Processo topo = minhaPilha.peek();
                    if(topo != null) 
                        System.out.println("Elemento no topo: " + topo);
                    else 
                        System.out.println("A pilha está vazia!");
                    break;

                case 4: 
                    // Isso aqui testa se iterator ta funcionando
                    System.out.println("\nProcessos na Pilha:");
                    for(Processo s : minhaPilha) {
                        System.out.println(s);
                    }
                    break;
                    
                case 0: 
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }
}