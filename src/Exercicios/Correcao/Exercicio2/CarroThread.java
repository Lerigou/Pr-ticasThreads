package Exercicios.Correcao.Exercicio2;

import java.util.concurrent.Callable;

public class CarroThread implements Callable<Integer> {

    private Corrida corrida;
    private Carro carro;

    public CarroThread(Corrida corrida, Carro carro) {
        this.corrida = corrida;
        this.carro = carro;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Iniciando a execução do carro " + carro.getNumero());
        this.corrida.chegada(carro);

        System.out.println("Finalizando a execução do carro " + carro.getNumero());
        return null;
    }
}
