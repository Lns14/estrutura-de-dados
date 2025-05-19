import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ranking ranking = new Ranking(10);
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Adicionar vilão");
            System.out.println("2. Mostrar ranking");
            System.out.println("3. Mostra vilão mais malvado");
            System.out.println("4. Remover vilão");
            System.out.println("5. Ordenar vilões");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do vilão: ");
                    String nome = scanner.nextLine();
                    System.out.print("Nível de ameaça: ");
                    int nivel = scanner.nextInt();
                    ranking.adicionaVilao(new SuperViloes(nome, nivel));
                    break;
                case 2:
                    ranking.mostrarRanking();
                    break;
                case 3:
                    ranking.buscaVilao();
                    break;
                case 4:
                    System.out.print("Nome do vilão para remover: ");
                    String nomeRemover = scanner.nextLine();
                    ranking.removeVilao(nomeRemover);
                    break;
                case 5:
                    ranking.ordenaViloes(ranking.getRankingSuperViloes(), 0, ranking.getElementos() - 1);
                    System.out.println("Ranking ordenado!");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}