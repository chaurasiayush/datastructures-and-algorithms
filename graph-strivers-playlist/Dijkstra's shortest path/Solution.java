//Link: https://www.naukri.com/code360/problems/dijkstra's-shortest-path_985358

import java.util.*;

public class Solution {
    
    public static class Pair {
        int node;
        int distance;
        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    public static List<Integer> dijkstra(int[][] edge,int vertices, int edges,int source){
        
        // create graph first
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<vertices; i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int i=0; i<edges; i++) {
            adj.get(edge[i][0]).add(new Pair(edge[i][1], edge[i][2]));
            adj.get(edge[i][1]).add(new Pair(edge[i][0], edge[i][2]));
        }


        int paths[] = new int[vertices];
        Arrays.fill(paths, Integer.MAX_VALUE);

        paths[source] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);

        pq.add(new Pair(source, 0));

        while(!pq.isEmpty()){
            Pair np = pq.poll();
            for(Pair ad : adj.get(np.node)){
                if(paths[ad.node] > np.distance + ad.distance) {
                    paths[ad.node] = np.distance + ad.distance;
                    pq.add(new Pair(ad.node, paths[ad.node]));
                }
            }
        }

       List<Integer> shortestPaths = new ArrayList<>();
       for(int i =0; i< vertices; i++) {
           if(paths[i] != Integer.MAX_VALUE) {
               shortestPaths.add(paths[i]);
           } else {
               shortestPaths.add(-1);
           }
       }

        return shortestPaths;
    }
}
