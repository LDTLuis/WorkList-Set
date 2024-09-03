import java.util.HashSet;
import java.util.Set;

public class ListaTarefa {

    private Set<Tarefa> tarefaSet;

    public ListaTarefa() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = null;
        if(!tarefaSet.isEmpty()) {
            for(Tarefa t : tarefaSet) {
                if(t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover = t;
                    break;
                }
            }
            tarefaSet.remove(tarefaParaRemover);
        } else {
            System.out.println("O conjunto está vazio");
        }

        if(tarefaParaRemover == null) {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public void exibirTarefa() {
        if(!tarefaSet.isEmpty()) {
            System.out.println(tarefaSet);
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public int contarTarefas() {
        return tarefaSet.size();
    }

    public Set<Tarefa> tarefasConcluidas() {
        Set<Tarefa> tarefaConcluida = new HashSet<>();
        for(Tarefa t : tarefaSet) {
            if (t.isConcluida()) {
                tarefaConcluida.add(t);
            }
        }
        return tarefaConcluida;
    }

    public Set<Tarefa> tarefasPendentes() {
        Set<Tarefa> tarefaPendente = new HashSet<>();
        for(Tarefa t : tarefaSet) {
            if(!t.isConcluida()) {
                tarefaPendente.add(t);
            }
        }
        return tarefaPendente;
    }

    public void marcarTarefaConcluida(String descricao) {
        for(Tarefa t : tarefaSet) {
            if(t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setConcluida(true);
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {
        Tarefa tarefaParaMarcarPendente = null;
        for(Tarefa t : tarefaSet) {
            if(t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaParaMarcarPendente = t;
                break;
            }
        }

        if (tarefaParaMarcarPendente != null) {
            if(tarefaParaMarcarPendente.isConcluida()) {
                tarefaParaMarcarPendente.setConcluida(false);
            }
        } else {
            System.out.println("Tarefa não encontrada na lista.");
        }
    }

    public void limparListaTarefas() {
        if(tarefaSet.isEmpty()) {
            System.out.println("A lista está vazia!");
        } else {
            tarefaSet.clear();
        }
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();

        listaTarefa.adicionarTarefa("Estudar Java");
        listaTarefa.adicionarTarefa("Ir para academia");
        listaTarefa.adicionarTarefa("Organizar o computador");
        listaTarefa.adicionarTarefa("Estudar Python");

        System.out.println("Lista de Tarefas:");
        listaTarefa.exibirTarefa();

        listaTarefa.removerTarefa("Organizar o computador");
        System.out.println("\nLista de Tarefas:");
        listaTarefa.exibirTarefa();

        System.out.println("\nTarefas pendentes: " + listaTarefa.tarefasPendentes());
        System.out.println("\nTotal de tarefas na lista: " + listaTarefa.contarTarefas());

        listaTarefa.marcarTarefaConcluida("Estudar Java");

        System.out.println("\nTarefas concluidas:" + listaTarefa.tarefasConcluidas());

        listaTarefa.limparListaTarefas();
        listaTarefa.exibirTarefa();

    }
}
