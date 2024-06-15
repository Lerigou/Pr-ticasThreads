package Exemplo3;

import Exemplo1.ExemploThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainMultiThread {

    public static void main(String[] args){
//        System.out.println("Iniciando");
//        ExecutorService executor = Executors.newFixedThreadPool(4); //roda n threads por vez, fazendo o gerenciamento dela,
//        // ent se tem 4 threads rodando ao msm tempo, mas existem 5 threads a serem executadas, a primeira thread q finalizar
//        // o processo, vai ser a thread q a thread faltante vai ser executada. ele reaproveita o thread
//        executor.execute(new ExemploThread());
//        executor.execute(new ExemploThread());
//        executor.execute(new ExemploThread());
//        executor.execute(new ExemploThread());
//        executor.execute(new ExemploThread());
//        executor.shutdown();
//        System.out.println("Encerrando");

        System.out.println("Iniciando");
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new ExemploThread());
        executor.execute(new ExemploThread());
        executor.execute(new ExemploThread());
        executor.execute(new ExemploThread());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.execute(new ExemploThread());
        executor.execute(new ExemploThread());
        executor.execute(new ExemploThread());
        executor.shutdown();
        System.out.println("Encerrando");
    }
}
