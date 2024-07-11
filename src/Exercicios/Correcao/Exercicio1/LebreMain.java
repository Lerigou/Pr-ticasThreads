package Exercicios.Correcao.Exercicio1;

import java.util.ArrayList;
import java.util.List;

public class LebreMain {

    public static void main(String[] args) {
        Classificacao classificacao = new Classificacao();
        List<Lebre> lebres = new ArrayList<Lebre>();
        for (int i = 0; i < 5; i++) {
            lebres.add(new Lebre("lebre" + i));
        }

        List<Thread> threads = new ArrayList<Thread>();
        for (Lebre lebre : lebres) {
            threads.add(new Thread(new LabreThread(lebre, classificacao)));
        }

        for (Thread thread : threads){
            thread.start();
        }

        for (Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Corrida finalizada");

    }
}
