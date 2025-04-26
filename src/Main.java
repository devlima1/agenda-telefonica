import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Remover Contato");
            System.out.println("3. Buscar Contato");
            System.out.println("4. Listar Contatos");
            System.out.println("5. Editar Contato");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Telefone: ");
                    String telefone = scanner.nextLine();
                    agenda.adicionarContato(new Contato(nome, telefone));
                    System.out.println("Contato adicionado!");
                    break;

                case 2:
                    System.out.println("Nome do contato para remover: ");
                    String nomeRemover = scanner.nextLine();
                    if (agenda.removerContato(nomeRemover)) {
                        System.out.println("Contato removido.");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Nome do contato para buscar: ");
                    String nomeBuscar = scanner.nextLine();
                    Contato c = agenda.buscarContato(nomeBuscar);
                    if(c != null) {
                        System.out.println("Contato encontrado: " + c);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\nContatos:");
                    agenda.listarContatos();
                    break;

                case 5:
                    System.out.println("Nome do contato para editar: ");
                    String nomeEditar = scanner.nextLine();
                    System.out.println("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.println("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();

                    Contato novoContato = new Contato(novoNome, novoTelefone);
                    if (agenda.editarContato(nomeEditar, novoContato)) {
                        System.out.println("Contato editado com sucesso.");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
