package Exercicios.Exercicio2;

import java.util.Random;

public class Competidor implements Runnable {
    private static final int MAX_SLEEP_TIME = 500; // Tempo máximo de espera
    private final int id;
    private final Campeonato campeonato;
    private final Random random;
    private int pontuacaoTotal;

    public Competidor(int id, Campeonato campeonato) {
        this.id = id;
        this.campeonato = campeonato;
        this.random = new Random();
        this.pontuacaoTotal = 0;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(MAX_SLEEP_TIME));
            System.out.println("Competidor " + id + " terminou a corrida.");

            // Adiciona a posição final ao campeonato
            campeonato.registrarChegada(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void adicionarPontos(int pontos) {
        pontuacaoTotal += pontos;
    }

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public int getId() {
        return id;
    }
}
