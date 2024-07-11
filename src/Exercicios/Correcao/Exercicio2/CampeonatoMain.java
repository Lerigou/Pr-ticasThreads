package Exercicios.Correcao.Exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CampeonatoMain {

    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<Carro>();

        for (int i = 0; i <= 10; i++) {
            carros.add(new Carro(i));
        }

        List<Corrida> corridas = new ArrayList<Corrida>();
        for (int i = 0; i < 10; i++) {
            corridas.add(new Corrida("Corrida " + i));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (Corrida corrida : corridas){
            System.out.println("-------- Corrida " + corrida.getNomeCorrida());
            List<CarroThread> threads = new ArrayList<CarroThread>();
            for (Carro carro : carros){
                threads.add(new CarroThread(corrida, carro));
            }

            try {
                executorService.invokeAll(threads);
                //thread sleep só q pro execute
                executorService.awaitTermination(3, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
    }
}
