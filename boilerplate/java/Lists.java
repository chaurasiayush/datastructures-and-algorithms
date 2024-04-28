import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lists {
    public static void main(String[] args) {

        // create an empty one dimentional list
        List<Integer> oneDimentionalList = new ArrayList<Integer>();
        System.out.println("empty one dimentional list: " + oneDimentionalList);

        // create one dimentional list of a known "capacity"
        List<Integer> oneDimentionalListOfSize = new ArrayList<>(3);
        System.out.println("one dimentional list of a known capacity: " + oneDimentionalListOfSize);

        // create one dimentional list of known size with default value
        List<Integer> oneDimentionalListOfSizeWithDefaultValue = new ArrayList<>(Collections.nCopies(5, -1));
        System.out.println("one dimentional list of a known size with default value: " + oneDimentionalListOfSizeWithDefaultValue);


        // create one dimentional list from an array
        Integer arr[] = {1,2,3,4,5};
        List<Integer> oneDimentionaListFromArray = new ArrayList<>(Arrays.asList(arr));
        System.out.println("one dimentional list from an array:"  + oneDimentionaListFromArray);
        Collections.addAll(oneDimentionaListFromArray, arr);
        // oneDimentionaListFromArray.addAll(Arrays.asList(arr));
        System.out.println("alternative one dimentional list from an array:"  + oneDimentionaListFromArray);

        // create an empty two dimentional List
        List<List<Integer>> twoDimentionalList = new ArrayList<>();
        System.out.println("two dimentional empty list:"  + twoDimentionalList);

        // create a two dimentional list of known size
        List<List<Integer>> twoDimentionalListOfKnownSize = new ArrayList<>(5);
        for (int i=0; i<5; i++){
            twoDimentionalListOfKnownSize.add(new ArrayList<>(5));
        }
        System.out.println("two dimentional list of known size:"  + twoDimentionalListOfKnownSize);
        
        // create a two dimentional list of known size with default value
        List<List<Integer>> twoDimentionalListOfKnownSizeWithDefaultValue = new ArrayList<>(3);
        for (int i=0; i<3; i++){
            twoDimentionalListOfKnownSizeWithDefaultValue.add(new ArrayList<>(Collections.nCopies(3, -1)));
        }
        System.out.println("two dimentional list of known size:"  + twoDimentionalListOfKnownSizeWithDefaultValue);

        //alternate way of creating a two dimentional list of known size with default value
        twoDimentionalListOfKnownSizeWithDefaultValue = new ArrayList<>(Collections.nCopies(3, new ArrayList<Integer>(Collections.nCopies(3, 0))));
        System.out.println("alternate two dimentional list of known size:"  + twoDimentionalListOfKnownSizeWithDefaultValue);
        twoDimentionalListOfKnownSizeWithDefaultValue.get(0).set(0, 3);
        System.out.println("alternate two dimentional list of known size:"  + twoDimentionalListOfKnownSizeWithDefaultValue);


        // get an element from the list
        int element = oneDimentionaListFromArray.get(3);
        System.out.println("element at index 3 in one dimentional list: "  + element + " - " + oneDimentionaListFromArray);

        // set an element in the list
        oneDimentionaListFromArray.set(4,99);
        System.out.println("set element at index 4 in one dimentional list: " + oneDimentionaListFromArray);

        // remove an element from List
        int removedElement = oneDimentionaListFromArray.remove(4);
        System.out.println("removed element from index 4 in one dimentional list: " + removedElement + " - " + oneDimentionaListFromArray);

        // get size of the list
        int size = oneDimentionaListFromArray.size();
        System.out.println("size of the list: " + size);
        
    }
}
