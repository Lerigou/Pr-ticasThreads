package Exercicios.Correcao.Exercicio1;

public class LabreThread implements Runnable{

    private Lebre lebre;
    private Classificacao classificacao;

    public LabreThread(Lebre lebre, Classificacao classificacao) {
        this.lebre = lebre;
        this.classificacao = classificacao;
    }

    @Override
    public void run() {
        while (lebre.getTotalPercorrido() < 20){
            lebre.saltar();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.classificacao.adicionarClassificacao(lebre);
    }
}
