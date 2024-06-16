package Exercicios.Exercicio3;

public class FabricaCarros {
    public static void main(String[] args) {
        int qtdConjuntos = 100;
        int qtdConstrutores = 5;
        int qtdMontadores = 3;
        int qtdPilotos = 2;

        Esteira esteira = new Esteira(30);
        Garagem garagem = new Garagem(20);

        // Distribui as tarefas para construtores
        int conjuntosPorConstrutor = qtdConjuntos / qtdConstrutores;
        int restoConstrutores = qtdConjuntos % qtdConstrutores;

        Thread[] construtores = new Thread[qtdConstrutores];
        for (int i = 0; i < qtdConstrutores; i++) {
            int conjuntosParaConstruir = conjuntosPorConstrutor + (i == 0 ? restoConstrutores : 0);
            construtores[i] = new Thread(new Construtor(esteira, conjuntosParaConstruir), "Construtor " + (i + 1));
            construtores[i].start();
        }

        // Distribui as tarefas para montadores
        int carrosPorMontador = qtdConjuntos / qtdMontadores;
        int restoMontadores = qtdConjuntos % qtdMontadores;

        Thread[] montadores = new Thread[qtdMontadores];
        for (int i = 0; i < qtdMontadores; i++) {
            int carrosParaMontar = carrosPorMontador + (i == 0 ? restoMontadores : 0);
            montadores[i] = new Thread(new Montador(esteira, garagem, carrosParaMontar), "Montador " + (i + 1));
            montadores[i].start();
        }

        // Distribui as tarefas para pilotos de teste
        int carrosPorPiloto = qtdConjuntos / qtdPilotos;
        int restoPilotos = qtdConjuntos % qtdPilotos;

        Thread[] pilotos = new Thread[qtdPilotos];
        for (int i = 0; i < qtdPilotos; i++) {
            int carrosParaTestar = carrosPorPiloto + (i == 0 ? restoPilotos : 0);
            pilotos[i] = new Thread(new PilotoDeTeste(garagem, carrosParaTestar), "Piloto " + (i + 1));
            pilotos[i].start();
        }

        // Espera todas as threads terminarem
        try {
            for (Thread construtor : construtores) {
                construtor.join();
            }
            for (Thread montador : montadores) {
                montador.join();
            }
            for (Thread piloto : pilotos) {
                piloto.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Processo de construção de carros finalizado.");
    }
}
