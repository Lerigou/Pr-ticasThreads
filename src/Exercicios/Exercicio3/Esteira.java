package Exercicios.Exercicio3;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Esteira {
    private final int capacidadeMaxima;
    private int quantidadeAtual;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public Esteira(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.quantidadeAtual = 0;
    }

    public void adicionarPeças(int quantidade) throws InterruptedException {
        lock.lock();
        try {
            while (quantidadeAtual + quantidade > capacidadeMaxima) {
                notFull.await();
            }
            quantidadeAtual += quantidade;
            System.out.println("Adicionado " + quantidade + " conjuntos de peças. Quantidade atual na esteira: " + quantidadeAtual);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void removerPeças(int quantidade) throws InterruptedException {
        lock.lock();
        try {
            while (quantidadeAtual < quantidade) {
                notEmpty.await();
            }
            quantidadeAtual -= quantidade;
            System.out.println("Removendo " + quantidade + " conjuntos de peças. Quantidade atual na esteira: " + quantidadeAtual);
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
