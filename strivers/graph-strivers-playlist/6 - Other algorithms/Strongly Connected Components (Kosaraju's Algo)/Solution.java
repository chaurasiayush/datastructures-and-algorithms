// link: https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    private void dfs1(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = true;
        for(int it: adj.get(node)){
            if(!vis[it]) {
                dfs1(it, vis, adj, st);
            }
        }
        st.push(node);
    }
    
    private void dfs3(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        
        for(int it : adj.get(node)){
            if(!vis[it]) {
                dfs3(it, vis, adj);
            }
        }
    }
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //step 1: get the finish order for all the nodes
        Stack<Integer> st = new Stack<Integer>();
        boolean[] vis = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs1(i, vis, adj, st);
            }
        }
        
        
        //step 2: transpose / reverse the graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<V; i++) {
            adjT.add(new ArrayList<Integer>());
        }
        
        
        for(int i=0; i<V; i++) {
            vis[i] = false;
            for(int it : adj.get(i)){
                // i -> it current
                // it -> i reversed
                adjT.get(it).add(i);
            }
        }
        
        
        // step 3: visit the graph in finish order
        
        // reset visited array
        // Arrays.fill(vis, false);
        
        int scc = 0;
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            
            if(!vis[node]){
                dfs3(node, vis, adjT);
                scc++;
            }
        }
        
        return scc;
    }
}
