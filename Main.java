public class Main {
    public static void main(String[] args) {

        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        Tarefa tarefa1 = new Tarefa("Jogar o lixo", false);
        Tarefa tarefa2 = new Tarefa("Programar isso", false);
        Tarefa tarefa3 = new Tarefa("Terminar o CRUD", false);
        Tarefa tarefa4 = new Tarefa("Aprender python", false);

        gerenciador.adicionarTarefa(tarefa1);
        gerenciador.adicionarTarefa(tarefa2);
        gerenciador.adicionarTarefa(tarefa3);
        gerenciador.adicionarTarefa(tarefa4);

        gerenciador.concluirTarefa("Programar isso");

        for (Tarefa tarefa : gerenciador.listarTarefas()) {
            System.out.println("Tarefa: " + tarefa.nome + " | Concluída: " + tarefa.concluida);
        }

        gerenciador.removerTarefa("Aprender python");

        System.out.println("Após a remoção da tarefa:");

        for (Tarefa tarefa : gerenciador.listarTarefas()) {
            System.out.println("Tarefa: " + tarefa.nome + " | Concluída: " + tarefa.concluida);
        }

    }
}