//link: https://leetcode.com/problems/critical-connections-in-a-network/

import java.util.*;

class Solution {
    private int time;

    private void DFS(int node, int parent, boolean[] visited, int[] time, int[] low, List<List<Integer>> adj, List<List<Integer>> bridges) {
        visited[node] = true;
        time[node] = this.time;
        low[node] = this.time;
        this.time++;

        for(int ad: adj.get(node)) { 
            if(ad == parent) continue;
            if(!visited[ad]) {
                DFS(ad, node, visited, time, low, adj, bridges);
                low[node] = Math.min(low[node], low[ad]);

                if(low[ad] > time[node]) {
                    ArrayList<Integer> bridge = new ArrayList<>();
                    bridge.add(node);
                    bridge.add(ad);
                    bridges.add(bridge);
                }
            } else {
                low[node] = Math.min(low[node], low[ad]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //create a adj list 
        List<List<Integer>> adj = new ArrayList<>(n);

        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<connections.size(); i++){
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int[] time = new int[n];
        int[] low = new int[n];
        this.time = 0;

        List<List<Integer>> bridges = new ArrayList<>();

        DFS(0, -1, visited, time, low, adj, bridges);
        return bridges;

    }
}