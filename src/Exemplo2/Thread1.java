package Exemplo2;

public class Thread1 implements Runnable{

    private Print print;
    public Thread1(Print print){
        super();
        this.print = print;
    }

    @Override
    public void run() {
        System.out.println("Iniciando exxecução: " + Thread.currentThread().getName());
        print.print(50);
//        this.notify(); //notifica as threads finalizadas, q liberou algo
        System.out.println("Finalizando a execução da Thread: " + Thread.currentThread().getName());

    }
}
