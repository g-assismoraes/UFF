package uff.ic.lleme.tcc00328.s20202.exemplo.thread.threadsDisputandoObjeto;

public class ThreadCalculaSoma extends Thread {

    private Tarefa tarefa = null;

    public ThreadCalculaSoma(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public void run() {
        tarefa.calculaSoma();
    }
}
