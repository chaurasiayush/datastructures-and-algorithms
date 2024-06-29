import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.Timer;

public class StreamApis {

    // Predicate -> one I/P, one O/P (true/false)
    // Function -> one I/P, one O/P
    // BiFunction -> two I/P, one O/P

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            list.add(i);
        }

        
        list.stream()
        .filter(a -> a%2 == 0)
        .sorted((a, b) -> b-a);
        // .collect();
        // .map(null)

        System.out.println(d);
    }
}
