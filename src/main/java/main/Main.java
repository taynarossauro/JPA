package main;
//Importando bibliotecas
import dao.ProdutoDAO;
import models.Produto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //instanciando objetos
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Scanner scanner = new Scanner(System.in);

        //menu opções para usuário
        while (true) {
            System.out.println("\nSistema de Gerenciamento de Produtos");
            System.out.println("1. Inserir Produto");
            System.out.println("2. Ler Produto por ID");
            System.out.println("3. Listar Todos os Produtos");
            System.out.println("4. Atualizar Produto");
            System.out.println("5. Excluir Produto");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // buffer do scanner

            // Inserir Produto
            if (opcao == 1) { 
                Produto produto = new Produto();
                System.out.print("Digite o nome do produto: ");
                produto.setNome(scanner.nextLine());

                System.out.print("Digite o preço do produto: ");
                produto.setPreco(scanner.nextDouble());
                scanner.nextLine(); // Limoa o buffer
                
                // Ler Produto
                produtoDAO.criar(produto);
                System.out.println("Produto inserido com sucesso!");
            } else if (opcao == 2) { 
                System.out.print("Digite o ID do produto: ");
                Long id = scanner.nextLong();
                scanner.nextLine();

                Produto produto = produtoDAO.ler(id);
                if (produto != null) {
                    System.out.println("Produto encontrado:");
                    System.out.println("ID: " + produto.getId());
                    System.out.println("Nome: " + produto.getNome());
                    System.out.println("Preço: " + produto.getPreco());
                } else {
                    System.out.println("Produto com ID " + id + " não encontrado.");
                }
            // Listar Todos os Produtos
            } else if (opcao == 3) { 
                System.out.println("\nLista de produtos:");
                produtoDAO.listarTodos().forEach(p -> 
                    System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome() + " | Preço: " + p.getPreco())
                );
            // Update Produto
            } else if (opcao == 4) {
                System.out.print("Digite o ID do produto a ser atualizado: ");
                Long id = scanner.nextLong();
                scanner.nextLine();

                Produto produto = produtoDAO.ler(id);
                if (produto != null) {
                    System.out.print("Digite o novo nome do produto (anterior: " + produto.getNome() + "): ");
                    produto.setNome(scanner.nextLine());

                    System.out.print("Digite o novo preço do produto (anterior: " + produto.getPreco() + "): ");
                    produto.setPreco(scanner.nextDouble());
                    scanner.nextLine();

                    produtoDAO.atualizar(produto);
                    System.out.println("Produto atualizado com sucesso!");
                } else {
                    System.out.println("Produto com ID " + id + " não encontrado.");
                }
            // Excluir Produto
            } else if (opcao == 5) {
                System.out.print("Digite o ID do produto a ser excluído: ");
                Long id = scanner.nextLong();
                scanner.nextLine();

                Produto produto = produtoDAO.ler(id);
                if (produto != null) {
                    produtoDAO.excluir(id);
                    System.out.println("Produto excluído com sucesso!");
                } else {
                    System.out.println("Produto com ID " + id + " não encontrado.");
                }
            // Sair
            } else if (opcao == 6) {
                System.out.println("Saindo do sistema...");
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
