// link: https://www.naukri.com/code360/problems/single-source-shortest-path_8416371

import java.util.*;
public class Solution {

    private static int[] getBfsShortestPaths(List<List<Integer>> adj, int src, int n){
        int paths[] = new int[n];
        Arrays.fill(paths, -1);
        
        Stack<Integer[]> s = new Stack<>();
        paths[src] = 0;
        s.push(new Integer[]{src, 0});

        while(!s.isEmpty()) {
            Integer node[] = s.peek();
            s.pop();

            for(int ad : adj.get(node[0])) {
               if((paths[ad] == -1) || (paths[ad] > node[1] + 1)) {
                   paths[ad] = node[1]+1;
                    s.push(new Integer[] {ad, paths[ad]});
               }
            }
        }

        return paths;
    } 
    public static int[] shortestPath(int n, int [][]edges, int src) {
        List<List<Integer>> adj = new ArrayList();

        for(int i=0;i<n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int shortestPaths[] = getBfsShortestPaths(adj, src, n);
        // shortestPaths.
        return shortestPaths;
    }
}