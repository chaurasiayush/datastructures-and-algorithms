import java.util.Arrays;

class Array {

    private static String oneDimentionalArrayString(int anArray[]) {
        String arrayString =  "[";
        for(int e : anArray) {
            arrayString += e + ", ";
        }
        arrayString += "]";
        return arrayString;
    }

    private static String twoDimentionalArrayString(int anArray[][]) {
        String arrayString = "[";
        String eArrayString = "";
        for(int[] earray : anArray) {
            eArrayString = "[";
            for(int e : earray) {
                eArrayString += e + ", ";
            }
            eArrayString += "], ";
            arrayString += eArrayString;
        }
        arrayString += "]";
        return arrayString;
    }

    public static void main(String args[]) {
        // one dimentional array
        int oneDimentionalArray[] = {};
        System.out.println(oneDimentionalArray.length);

        // one dimentional array of known size
        int oneDimentionalArrayOfSize[] = new int[3];
        System.out.println("one dimetional array of known size: " + oneDimentionalArrayString(oneDimentionalArrayOfSize));

        // one dimetional array with known values
        int oneDimentionalArrayWithKnownValues[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("one directional array with known values: " + oneDimentionalArrayString(oneDimentionalArrayWithKnownValues));

        // one dimentional array with size and default value
        int oneDimentionalArrayWithSizeAndDefaultValue[] = new int[3];
        Arrays.fill(oneDimentionalArrayWithSizeAndDefaultValue, -1); // or loop though and replace values
        System.out.println("one directional array with size and default value: " + oneDimentionalArrayString(oneDimentionalArrayWithSizeAndDefaultValue));


        // two dimentional array 
        int twoDimentionalArray[][] = {};
        System.out.println("two directional array: " + twoDimentionalArrayString(twoDimentionalArray));

        // two dimentional array with known size
        int twoDimentionalArrayWithKnownSize[][] = new int[3][3];
        System.out.println("two directional array with known size: " + twoDimentionalArrayString(twoDimentionalArrayWithKnownSize));
        
        // two dimetional array with known values
        int twoDimentionalArrayWithKnownValues[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println("two directional array with known values: " + twoDimentionalArrayString(twoDimentionalArrayWithKnownValues));

        // two dimentional array with known size and default value
        int twoDimentionalArrayWithKnownSizeAndDefaultValue[][] = new int[3][3];
        for(int[] earray : twoDimentionalArrayWithKnownSizeAndDefaultValue) {
            Arrays.fill(earray, -1);
        }
        System.out.println("two directional array with known size and default value: " + twoDimentionalArrayString(twoDimentionalArrayWithKnownSizeAndDefaultValue));
    }
}