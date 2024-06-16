package Exercicios.Exercicio2;

public class CampeonatoMain {
    public static void main(String[] args) throws InterruptedException {
        int numCorridas = 20; // Número de corridas
        Campeonato campeonato = new Campeonato(numCorridas);
        campeonato.iniciarCorridas();
    }
}

