package Exemplo2;

public class Print {

//    public void print(int num){
//        for (int i = 0; i < 10;i++){
//            System.out.println(num+i);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }

    //espera uma thread terminar pra começar a próxima, deixa a próxima thread em waiting
    public synchronized void print(int num){
        for (int i = 0; i < 10;i++){
            System.out.println(num+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
