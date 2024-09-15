//link: https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Item(Integer.parseInt(inputLine[k++]),
                                  Integer.parseInt(inputLine[k++]));
            }
            System.out.println(
                String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {
        
        // need to sort the Item array according to its unit price
        Arrays.sort(arr, (a, b)-> {
             return ((double)b.value/b.weight) > ((double)a.value/a.weight) ? 1: -1
            });
        
        double maxVal = 0;
        
        for(int i=0; i<arr.length && w > 0; i++){
            // System.out.println(arr[i].value +" " +arr[i].weight);
            Item current = arr[i];
            int weight = current.weight;
            int value = current.value;
            
            if(weight <= w) {
                maxVal += value;
                w -= weight;
            } else {
                maxVal += ((double)value/weight)*w;
                w = 0;
            }
            
        }
        
        return maxVal;
        
    
        
    }
}