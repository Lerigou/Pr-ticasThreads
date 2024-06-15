package Exemplo4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExemploCyclic {

    // (22*22) + (33*5.6) + (45/0.5)
    public static void main(String[] args){

        List<Double> resultados = new ArrayList<Double>();

        Runnable resultThread = new Runnable() {
            @Override
            public void run() {
                double resultadoFinal = 0;
                for (Double d: resultados){
                    resultadoFinal += d;
                }

                System.out.println("Resultado final: " + resultadoFinal);
            }
        };

        CyclicBarrier barrier = new CyclicBarrier(3, resultThread); // espera n threads avisaram q finalizaram, para q só ent iniciar a execjção das outras thread

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Iniciando R1: " + Thread.currentThread().getName());

                double result = 22d*22d;
                resultados.add(result);

                System.out.println("Finalizando R1: " + Thread.currentThread().getName());
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Iniciando R2: " + Thread.currentThread().getName());

                double result = 33d*5.6d;
                resultados.add(result);

                System.out.println("Finalizando R2: " + Thread.currentThread().getName());
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Iniciando R3: " + Thread.currentThread().getName());

                double result = 45d/0.5d;
                resultados.add(result);

                System.out.println("Finalizando R3: " + Thread.currentThread().getName());
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        };

        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);

        executor.shutdown();
    }
}
