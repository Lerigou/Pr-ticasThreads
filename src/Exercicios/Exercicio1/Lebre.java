package Exercicios.Exercicio1;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Lebre implements Runnable {
    private static final int DISTANCIA_TOTAL = 20;
    private int qtdPulos;
    private final String nome;
    private int distanciaPercorrida;
    private final CyclicBarrier barrier;
    private final List<Lebre> ordemDeChegada;
    private final Random random;

    public Lebre(String nome, CyclicBarrier barrier, List<Lebre> ordemDeChegada) {
        this.nome = nome;
        this.barrier = barrier;
        this.ordemDeChegada = ordemDeChegada;
        this.random = new Random();
        this.distanciaPercorrida = 0;
    }

    @Override
    public void run() {
        try {
            System.out.println(nome + " está pronta!");
            barrier.await(); // Espera todas as lebres estarem prontas para começar

            while (distanciaPercorrida < DISTANCIA_TOTAL) {
                int salto = random.nextInt(3) + 1; // Gera um salto de 1 a 3 metros
                qtdPulos++;
                distanciaPercorrida += salto;
                System.out.println(nome + " saltou " + salto + " metros. " +
                        "Distância percorrida: " + distanciaPercorrida);

                // Simula o tempo de descanso
                Thread.sleep(500); // 500 milissegundos = 0.5 segundos
            }

            synchronized (ordemDeChegada) {
                ordemDeChegada.add(this);
                System.out.println("----- " + nome + " cruzou a linha de chegada! ------");
            }

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public String getNome() {
        return nome;
    }

    public int getQtdPulos(){
        return qtdPulos;
    }
}
