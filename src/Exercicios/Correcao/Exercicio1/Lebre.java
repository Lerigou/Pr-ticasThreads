package Exercicios.Correcao.Exercicio1;

import java.util.Random;

public class Lebre {


    private String nome;
    private int totalPercorrido;

    public Lebre(String nome, int totalPercorrido) {
        this.nome = nome;
        this.totalPercorrido = totalPercorrido;
    }

    public void saltar(){
        int salto = new Random().nextInt(3) + 1;
        this.totalPercorrido += salto;
        System.out.println("Lebre " + nome + " saltou " + salto + " total percorrido " + totalPercorrido);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTotalPercorrido() {
        return totalPercorrido;
    }

    public void setTotalPercorrido(int totalPercorrido) {
        this.totalPercorrido = totalPercorrido;
    }
}
