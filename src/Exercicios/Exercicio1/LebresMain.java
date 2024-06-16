package Exercicios.Exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class LebresMain {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        int numLebres = 5;
        CyclicBarrier barrier = new CyclicBarrier(numLebres + 1); // +1 para a main thread

        List<Lebre> ordemDeChegada = new ArrayList<>();
        Thread[] threads = new Thread[numLebres];
        Lebre[] lebres = new Lebre[numLebres];

        for (int i = 0; i < numLebres; i++) {
            lebres[i] = new Lebre("Lebre " + (i + 1), barrier, ordemDeChegada);
            threads[i] = new Thread(lebres[i]);
            threads[i].start();
        }

        System.out.println("A corrida vai começar em 3 segundos...");
        Thread.sleep(3000);

        System.out.println("\n----- Corrida Iniciada! -----\n");
        barrier.await(); // Libera as lebres para começarem a correr

        // Aguarda o término de todas as threads das lebres
        for (Thread thread : threads) {
            thread.join();
        }

        // Imprime os resultados finais da corrida baseado na ordem de chegada
        System.out.println("\nResultado final da corrida:\n");
        for (int i = 0; i < ordemDeChegada.size(); i++) {
            Lebre lebre = ordemDeChegada.get(i);
            System.out.println(lebre.getNome() + " chegou em " + (i + 1) + "º lugar com " +
                    lebre.getDistanciaPercorrida() + " metros percorridos e " + lebre.getQtdPulos() + " pulos.");
        }
    }
}
