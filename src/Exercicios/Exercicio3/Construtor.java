package Exercicios.Exercicio3;
public class Construtor implements Runnable {
    private final Esteira esteira;
    private final int conjuntosParaConstruir;

    public Construtor(Esteira esteira, int conjuntosParaConstruir) {
        this.esteira = esteira;
        this.conjuntosParaConstruir = conjuntosParaConstruir;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < conjuntosParaConstruir; i++) {
                esteira.adicionarPeças(1);
                System.out.println(Thread.currentThread().getName() + " construiu 1 conjunto de peças.");
                Thread.sleep(100); // Simula o tempo de construção
            }
            System.out.println(Thread.currentThread().getName() + " terminou a construção.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
