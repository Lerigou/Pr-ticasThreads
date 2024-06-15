package Exemplo3;

import Exemplo1.ExemploThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args){
        System.out.println("Execução iniciada: " + Thread.currentThread().getName());
        ExecutorService executor = Executors.newSingleThreadExecutor(); //cria o executor de uma única thread (além da thread main)
        executor.execute(new ExemploThread()); //ele executa sem precisar criar um thread
        executor.shutdown();//n permite a criação de novas threads com esse executor
        System.out.println("Execução finalizada");
    }
}
