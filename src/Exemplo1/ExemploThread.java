package Exemplo1;

import java.util.Random;

public class ExemploThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Iniciando a execução da Thread: " + Thread.currentThread().getName());

        try {
            Random random = new Random();
            int timeToSleep = random.nextInt(10)*1000;
            Thread.sleep(timeToSleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Finalizando a execução da Thread: " + Thread.currentThread().getName());

    }
}
