//link: https://www.naukri.com/code360/problems/shortest-path-in-dag_8381897
import java.util.*;
import javafx.util.Pair;

public class Solution {
    public static int[] bfsShortestPath(List<List<Pair<Integer, Integer>>> adj, int n) {
        int paths[] = new int[n];
        Arrays.fill(paths, -1);

        paths[0] = 0;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(0, 0));

        while(!q.isEmpty()) {
            Pair<Integer, Integer> node = q.peek();
            q.remove();
            for(Pair<Integer, Integer> ad: adj.get(node.getKey())){
                if(paths[ad.getKey()] == -1 || paths[ad.getKey()] > node.getValue() + ad.getValue()) {
                    paths[ad.getKey()] = node.getValue() + ad.getValue();
                    q.add(new Pair(ad.getKey(), paths[ad.getKey()]));
                }
            }
        }

        return paths;
    }
    public static int[] shortestPathInDAG(int n, int m, int [][]edges) {
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Pair<Integer, Integer>>());
        }

        for(int i=0; i < m ; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }

        return bfsShortestPath(adj, n);
    }
}