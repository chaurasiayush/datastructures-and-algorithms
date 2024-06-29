//Link: https://www.geeksforgeeks.org/problems/merge-k-sorted-arrays/1

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Triplet {
    int first;
    int second;
    int third;
    
    public Triplet(int f, int s, int t) {
        this.first = f;
        this.second = s;
        this.third = t;
    }
}

class Solution
{
    private static int[] mergeArray(int[] a1, int[] a2) {
        int l1 = a1.length;
        int l2 = a2.length;
        
        int[] marr = new int[l1+l2];
        int p1 = 0, p2 = 0, mp = 0;
        
        while(p1 < l1 && p2 < l2) {
            if(a1[p1] < a2[p2]) {
                marr[mp] = a1[p1];
                p1++;
            } else {
                marr[mp] = a2[p2];
                p2++;
            }
            mp++;
        }
        
        while(p1 < l1){
            marr[mp++] = a1[p1++];
        }
        
        while(p2 < l2){
            marr[mp++] = a2[p2++];
        }
        
        return marr;
    }
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        
        // int[] arr1 = arr[0];
        // int cr = 1;
        
        // while(cr < K) {
        //     int[] arr2 = arr[cr];
        //     int marr[] = mergeArray(arr1, arr2);
        //     arr1 = marr;
        //     cr++;
        // }
        
        // ArrayList<Integer> ans = new ArrayList<>();
        // for(int num : arr1) {
        //     ans.add(num);
        // }
        
        // return ans;

        return mergeKArraysOptimised(arr, K);
    }

    public static ArrayList<Integer> mergeKArraysOptimised(int[][] arr,int K) 
    {
        
        PriorityQueue<Triplet> heap = new PriorityQueue<>((a, b) -> a.first - b.first);
        ArrayList<Integer> ans = new ArrayList<>();
        
        //insert first element of all arrays to the heap
        for(int i=0; i<K; i++){
            Triplet tmp = new Triplet(arr[i][0], i, 0);
            heap.offer(tmp);
        }
        
        // remove first element from heap and insert next from the same array
        
        while(!heap.isEmpty()){
            Triplet min = heap.poll();
            
            int val = min.first;
            int array = min.second;
            int index = min.third;
            
            ans.add(val);
            
            
            if(index + 1 < K) {
                Triplet tmp = new Triplet(arr[array][index+1], array, index+1);
                heap.offer(tmp);
            }
        }
        
        return ans;
        
    }
}
