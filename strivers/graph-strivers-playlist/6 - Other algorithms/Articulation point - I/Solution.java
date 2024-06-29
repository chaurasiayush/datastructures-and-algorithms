// https://www.geeksforgeeks.org/problems/articulation-point-1/1

//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution
{
    private int timer;
    
    private void dfs(int node, int parent, boolean[] visited, int[] tin, int[] low, ArrayList<ArrayList<Integer>> adj, Set<Integer> artc) {
        visited[node] = true;
        tin[node] = this.timer;
        low[node] = this.timer;
        this.timer++;
        
        int count = 0;
        for(int it : adj.get(node)) {
            if(it == parent) continue;
            if(!visited[it]) {
                count++;
                dfs(it, node, visited, tin, low, adj, artc);
                low[node] = Math.min(low[node], low[it]);
                
                if(low[it] >= tin[node] && parent != -1) {
                    artc.add(node);
                }
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
            
        }
        if(parent == -1 && count > 1){
            artc.add(node);
        }
    }
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        
        this.timer = 1;
        Set<Integer> artset = new TreeSet<>();
        
        dfs(0, -1, visited, tin, low, adj, artset);
        
        if(artset.size() == 0) artset.add(-1);
        
        return new ArrayList(artset);
        
    }
}