import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForEachExample {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9);

        // intList.forEach((val) -> System.out.print(val + " "));
        Stream<Integer> intStream = intList.stream();

        // List<Integer> filtered = intStream.sorted((a, b)-> b-a).map(a-> a*2).filter(a -> a > 5 && a < 10).collect(Collectors.toList());

        Integer oval = intStream.reduce(10, (acc, a) -> acc+a);
        System.out.println("Accumulated: "+ oval);
        // filtered.forEach(a -> System.out.println(a));
        // System.out.print(lst);
    }
}


