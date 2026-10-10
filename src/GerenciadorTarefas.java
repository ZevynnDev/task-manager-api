import java.util.ArrayList;
import java.util.Iterator;

public class GerenciadorTarefas {
    ArrayList<Tarefa> tarefas = new ArrayList<>();


    void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    ArrayList<Tarefa> listarTarefas() {
        return tarefas;
    }

    void concluirTarefa(String nome) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.nome.equals(nome)) {
                tarefa.concluida = true;
            }
        }
    }

    void removerTarefa(String nome) {
     Iterator<Tarefa> iterator = tarefas.iterator();

     while (iterator.hasNext()) {
        Tarefa tarefa = iterator.next();


            if (tarefa.nome.equals(nome)) {
            iterator.remove();
            }
        }   
    }
}    