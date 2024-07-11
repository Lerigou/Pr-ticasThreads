package Exercicios.Correcao.Exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Classificacao {

    List<Lebre> lebres = new ArrayList<Lebre>();

    public synchronized void adicionarClassificacao(Lebre lebre){
        this.lebres.add(lebre);
    }

    public void imprimirClassificacaoFinal(){
        for (int i = 0; i <= 5; i++) {
            System.out.println(i + " - " + lebres.get(i-1).getNome());
        }
    }
}
