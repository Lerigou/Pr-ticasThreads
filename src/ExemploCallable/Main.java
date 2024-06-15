package ExemploCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args){
        try {
            List<ExemploCallable> list = List.of(new ExemploCallable(),new ExemploCallable(),new ExemploCallable(),new ExemploCallable(),new ExemploCallable());
            ExecutorService executor = Executors.newCachedThreadPool();
            Future<String> future1 = executor.submit(new ExemploCallable()); //executa e retorna um objrto do tive future,
            // o future nos dá algumas opções de métodos prontos, como a usada abaixo
            List<Future<String>> futures = executor.invokeAll(list); //lista de objetos q implementam o callable e executam ao msm tempo
//            System.out.println(future1.isDone());
//            String retorno = future1.get();
//            System.out.println(retorno);
//            System.out.println(future1.isDone());
            executor.shutdown();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
