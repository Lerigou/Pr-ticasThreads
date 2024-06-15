package Exemplo2;

public class Thread2 implements Runnable{

    public Print print;

    public Thread2(Print print) {
        this.print = print;
    }

    @Override
    public void run() {
        System.out.println("Iniciando execução: " + Thread.currentThread().getName());
        print.print(600);
        System.out.println("Finalizando a execução da Thread: " + Thread.currentThread().getName());

    }
}
