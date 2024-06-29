import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;



class CustomLambda {


    private static void check(CustomOperation<Integer> co, Integer a){
        co.perform(a);
    }
    public static void main(String[] args) {
        Consumer<Integer> c = new Consumer<>() {
            @Override
            public void accept(Integer t) {
                System.out.println(t);
            }
        };

        CustomOperation<Integer> cop = (a) -> System.out.println(a);

        List<Integer> lst = Arrays.asList(1,2,3,4,5,6,7);   
        lst.forEach(a -> check((b) -> System.out.println(b), a));     
    }
}

@FunctionalInterface
interface CustomOperation<T> {
    public void perform(T t);
    // public void p();
}