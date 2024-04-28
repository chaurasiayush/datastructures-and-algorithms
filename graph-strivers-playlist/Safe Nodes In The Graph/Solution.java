//link: https://www.naukri.com/code360/problems/safe-nodes-in-the-graph_1376703

import java.util.* ;
public class Solution {

    private static ArrayList<Integer> toposort(ArrayList<ArrayList<Integer>> adj, int n) {
        // calculate indegree
        int indegree[] = new int[n];

        for(int i=0; i<n; i++){
            for(int node : adj.get(i)){
               indegree[node]++; 
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // insert all the nodes with indegree 0 to the queue
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.peek();
            ans.add(node);
            q.remove();

            for(int ad : adj.get(node)){
                indegree[ad]--;
                if(indegree[ad] == 0) {
                    q.add(ad);
                }
            }
        }
        
        return ans;
    }
    public static ArrayList<Integer> safeNodes(int edges[][], int n, int e) {
        // Write your code here.
        // create a reverse graph

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<e; i++) {
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        ArrayList<Integer> topo = toposort(adj, n);
        Collections.sort(topo);
        return topo;
    }
}