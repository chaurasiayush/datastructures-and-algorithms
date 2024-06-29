import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumersExample {
    
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        // by implementing consumer interface
        Consumer<Integer> con = new Consumer<>(){
            @Override
            public void accept(Integer a){
                System.out.print(a + " ");
            }
        };

        // by creating object of custom consumer interface
        Consumer<Integer> ccon = new CustomConsumer<>();
        
        list.forEach(ccon);
        System.out.println();
        
        list.forEach(con);
        System.out.println();
        
        // by proving lambda expressions
        list.forEach(a -> System.out.print(a + " "));
    }
}

class CustomConsumer<T> implements Consumer<T> {

    @Override
    public void accept(T t) {
        System.out.print(t + " ");
    }

}
