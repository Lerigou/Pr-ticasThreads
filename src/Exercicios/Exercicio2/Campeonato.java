package Exercicios.Exercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Campeonato {
    private static final int NUM_COMPETIDORES = 10;
    private static final int[] PONTUACAO = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; // Pontuação para cada posição
    private final List<Competidor> competidores;
    private final Lock lock;
    private final int numCorridas;
    private List<Competidor> ordemChegada;

    public Campeonato(int numCorridas) {
        this.numCorridas = numCorridas;
        this.competidores = new ArrayList<>();
        this.lock = new ReentrantLock();

        for (int i = 1; i <= NUM_COMPETIDORES; i++) {
            competidores.add(new Competidor(i, this));
        }
    }

    public void iniciarCorridas() throws InterruptedException {
        for (int i = 0; i < numCorridas; i++) {
            System.out.println("\nIniciando corrida " + (i + 1));
            ordemChegada = Collections.synchronizedList(new ArrayList<>());

            List<Thread> threads = new ArrayList<>();
            for (Competidor competidor : competidores) {
                Thread thread = new Thread(competidor);
                threads.add(thread);
                thread.start();
            }

            for (Thread thread : threads) {
                thread.join();
            }

            registrarPontos();
        }

        anunciarCampeao();
    }

    public void registrarChegada(Competidor competidor) {
        lock.lock();
        try {
            ordemChegada.add(competidor);
            System.out.println("Competidor " + competidor.getId() + " chegou na posição " + ordemChegada.size());
        } finally {
            lock.unlock();
        }
    }

    private void registrarPontos() {
        System.out.println("Registrando pontos...");
        for (int i = 0; i < ordemChegada.size(); i++) {
            Competidor competidor = ordemChegada.get(i);
            int pontos = PONTUACAO[i];
            competidor.adicionarPontos(pontos);
            System.out.println("Competidor " + competidor.getId() + " recebe " + pontos + " pontos.");
        }
    }

    private void anunciarCampeao() {
        competidores.sort((c1, c2) -> {
            if (c1.getPontuacaoTotal() == c2.getPontuacaoTotal()) {
                return Integer.compare(c1.getId(), c2.getId());
            }
            return Integer.compare(c2.getPontuacaoTotal(), c1.getPontuacaoTotal());
        });

        Competidor campeao = competidores.get(0);

        System.out.println("\nCompetidor campeão: " + campeao.getId() + " com " + campeao.getPontuacaoTotal() + " pontos.");
        System.out.println("Classificação final:");
        for (Competidor competidor : competidores) {
            System.out.println("Competidor " + competidor.getId() + ": " + competidor.getPontuacaoTotal() + " pontos.");
        }
    }
}
