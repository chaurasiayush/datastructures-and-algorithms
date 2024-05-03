// Link: https://www.naukri.com/code360/problems/minimum-operations_8360665

import java.util.*;

public class Solution {

    public static class Pair {
        int first;
        int second;

        public Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }
    public static int djisktra(int start, int end, int []a) {
        int paths[] = new int[1000];
        Arrays.fill(paths, (int)1e5);
        Queue<Pair> q= new LinkedList<>();
        paths[start] = 0;

        q.add(new Pair(start, 0));

        while(!q.isEmpty()){
            Pair p = q.peek();
            q.remove();

            int node = p.first;
            int cost = p.second;

            if(node == end) return cost;

            for ( int i : a){
                int ad  = (i*node) % 1000;
                if(paths[ad] > paths[node] + 1) {
                    paths[ad] = paths[node] + 1;
                    q.add(new Pair(ad, paths[ad]));
                    
                }
            }
        }

        return -1;
    }
    public static int minimumOperations(int n, int start, int end, int []a) {
        
        return djisktra(start, end, a);
    }
}