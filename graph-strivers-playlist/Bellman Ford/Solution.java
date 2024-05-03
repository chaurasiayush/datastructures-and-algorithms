// Link:  https://www.naukri.com/code360/problems/bellman-ford_2041977

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Solution {

    private static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        
        int paths[] = new int[n+1];
        Arrays.fill(paths, (int)1e8);

        paths[src] = 0;

        // relax the edges n-1 times, where n is the number of edges
        // if on nth time, paths still reduces, then th graph is having a negative weight cycle
        for(int j=0; j<m-1; j++) {

            for(int i=0; i<m; i++) {
                int source = edges.get(i).get(0);
                int dest = edges.get(i).get(1);
                int cost = edges.get(i).get(2);
                if(paths[source] != (int)1e8 && paths[dest] > paths[source] + cost) {
                    paths[dest] = paths[source] + cost;
                }
            }
        }
        return paths;
    }
}
