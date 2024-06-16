package Exercicios.Exercicio3;

public class PilotoDeTeste implements Runnable {
    private final Garagem garagem;
    private final int carrosParaTestar;

    public PilotoDeTeste(Garagem garagem, int carrosParaTestar) {
        this.garagem = garagem;
        this.carrosParaTestar = carrosParaTestar;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < carrosParaTestar; i++) {
                garagem.removerCarro();
                System.out.println(Thread.currentThread().getName() + " testou 1 carro.");
                Thread.sleep(100); // Simula o tempo de teste
            }
            System.out.println(Thread.currentThread().getName() + " terminou o teste.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
