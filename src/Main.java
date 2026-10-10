import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TarefaDAO dao = new TarefaDAO();
    
    while (true) {


        System.out.println("=== TASK MANAGER ===");

        System.out.println("Escolha o que deseja fazer:");
        System.out.println("1. Cadastrar tarefa");
        System.out.println("2. Mostrar tarefas cadastradas");
        System.out.println("3. Excluir tarefas");
        System.out.println("0. Sair");
        

        int escolha = scanner.nextInt();

        if (escolha == 1) {
            scanner.nextLine();

            System.out.println("Digite o nome da tarefa:");
            String entrada = scanner.nextLine();

            Tarefa tarefa = new Tarefa(entrada, false);

            try {
                dao.adicionarTarefa(tarefa);
            } catch (SQLException erro) {
                System.out.println(erro.getMessage());
            }
        }
        else if (escolha == 2) {
            
            try {
                dao.listarTarefa();
            } 
            catch (SQLException erro) {
                System.out.println(erro.getMessage());
            }
        }
        else if (escolha == 3) {
            scanner.nextLine();
            
            System.out.println("Digite o id da tarefa:");
            int id_tarefa = scanner.nextInt();
            
            try {
            
                dao.apagarTarefa(id_tarefa);
            } catch (SQLException erro) {
                System.out.println(erro.getMessage());
            }
        }

        else if (escolha == 0) {
            break;
        }
        else {
            System.out.println("Erro: Opção inválida");
        }

        }

        scanner.close();
    }
}