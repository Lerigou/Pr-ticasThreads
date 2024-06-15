package ExemploCallable;

import java.util.Random;
import java.util.concurrent.Callable;

// o callable pode retornar outras coisas, n só String
public class ExemploCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Iniciando Thread: ");
        int num = new Random().nextInt(1000);
        Thread.sleep(num);
        System.out.println("Finalizando Thread: ");
        return Thread.currentThread().getName() + " - " + num;
    }
}
