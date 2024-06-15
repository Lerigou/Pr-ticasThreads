package Exemplo2;

public class PrintMain {

    public static void main(String[] args){
        Print p = new Print();
        Thread t1 = new Thread(new Thread1(p), "T1");
        Thread t2 = new Thread(new Thread2(p), "T2");
        t1.start();
        t2.start();
    }
}
