package Exercicios.Exercicio3;
public class Montador implements Runnable {
    private final Esteira esteira;
    private final Garagem garagem;
    private final int carrosParaMontar;

    public Montador(Esteira esteira, Garagem garagem, int carrosParaMontar) {
        this.esteira = esteira;
        this.garagem = garagem;
        this.carrosParaMontar = carrosParaMontar;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < carrosParaMontar; i++) {
                esteira.removerPeças(1);
                System.out.println(Thread.currentThread().getName() + " montou 1 carro.");
                garagem.adicionarCarro();
                Thread.sleep(100); // Simula o tempo de montagem
            }
            System.out.println(Thread.currentThread().getName() + " terminou a montagem.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
