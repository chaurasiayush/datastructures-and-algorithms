import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {

    private static String setString(Set<Integer> aset) {
        String setString = "{";
        for(int e : aset) {
            setString += e + ", ";
        }
        setString += "}";
        return setString;
    }
    
    public static void main (String args[]) {
        // creating an empty set
        Set<Integer> aHashSet = new HashSet<Integer>(); // does not guarantee order of the elements
        Set<Integer> aTreeSet = new TreeSet<Integer>(); // guarantees order of the elements, rest functions same as hashset
        System.out.println("empty hash set: " + setString(aHashSet));
        System.out.println("empty tree set: " + setString(aTreeSet));

        // create a set from an array
        Integer[] arr = {1, 2, 3, 4};
        Set<Integer> asetFromArray = new HashSet<Integer>();
        System.out.println("set from array: " + asetFromArray);

        // add an element to the set
        aHashSet.add(1);
        System.out.println("added element in the set " + aHashSet);
        
        // add a list of element in the set
        aHashSet.addAll(Arrays.asList(arr));
        System.out.println("added list of element in the set " + aHashSet);

        // check if the set contains an element
        boolean doesContain = aHashSet.contains(2);
        System.out.println("check for element 2 in the set: " + doesContain + " - " + aHashSet);

        // delete an element from the set
        boolean wasRemoved = aHashSet.remove(2);
        System.out.println("remove element 2 from the set: " + wasRemoved + " - " + aHashSet);

        new ArrayList<>(aHashSet);
    }
}
