package Exercicios.Exercicio3;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Garagem {
    private final int capacidadeMaxima;
    private int quantidadeAtual;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public Garagem(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.quantidadeAtual = 0;
    }

    public void adicionarCarro() throws InterruptedException {
        lock.lock();
        try {
            while (quantidadeAtual >= capacidadeMaxima) {
                notFull.await();
            }
            quantidadeAtual++;
            System.out.println("Adicionado 1 carro. Quantidade atual na garagem: " + quantidadeAtual);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void removerCarro() throws InterruptedException {
        lock.lock();
        try {
            while (quantidadeAtual == 0) {
                notEmpty.await();
            }
            quantidadeAtual--;
            System.out.println("Removido 1 carro. Quantidade atual na garagem: " + quantidadeAtual);
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
