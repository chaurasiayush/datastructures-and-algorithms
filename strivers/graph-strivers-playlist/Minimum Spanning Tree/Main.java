// Link: https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1

//{ Driver Code Starts


    import java.io.*;
    import java.lang.*;
    import java.util.*;
    
    public class Main {
        static BufferedReader br;
        static PrintWriter ot;
    
        public static void main(String args[]) throws IOException {
            br = new BufferedReader(new InputStreamReader(System.in));
            ot = new PrintWriter(System.out);
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                String s[] = br.readLine().trim().split(" ");
                int V = Integer.parseInt(s[0]);
                int E = Integer.parseInt(s[1]);
                List<List<int[]>> list = new ArrayList<>();
                for (int i = 0; i < V; i++) list.add(new ArrayList<>());
                for (int i = 0; i < E; i++) {
                    s = br.readLine().trim().split(" ");
                    int a = Integer.parseInt(s[0]);
                    int b = Integer.parseInt(s[1]);
                    int c = Integer.parseInt(s[2]);
                    list.get(a).add(new int[] {b, c});
                    list.get(b).add(new int[] {a, c});
                }
                ot.println(new Solution().spanningTree(V, E, list));
            }
            ot.close();
        }
    }
    // } Driver Code Ends
    
    // User function Template for Java
    class DisjointSet {
        
        private int[] parent;
        private int[] size;
        
        public DisjointSet(int n) {
            parent = new int[n+1];
            for(int i=0; i<n+1; i++){
                parent[i] = i;
            }
            size = new int[n+1];
        }
        
        public int findParent(int node) {
            if(parent[node] == node) return node;
            int nparent = findParent(parent[node]);
            
            parent[node] = nparent;
            return nparent;
        }
        
        public void unionBySize(int u, int v) {
            // need to add u, v to the same set
            int pu = findParent(u);
            int pv = findParent(v);
            
            if(pu == pv) return;
            
            if(size[pu] > size[pv]) {
                // add v to u
                parent[pv] = pu;
                size[pu] += size[pu];
                
            } else {
                parent[pu] = pv;
                size[pv] += size[pu];
            }
        }
    }
    
    
    class Solution {
        
        static int spanningTree(int V, int E, List<List<int[]>> adj) {
            
            //convert adj to edges
            List<int[]> edges = new ArrayList<>();
            
            for(int i=0; i<V; i++) {
                for(int[] ad : adj.get(i)){
                    edges.add(new int[]{i, ad[0], ad[1]});
                }
            }
            
            // sort the list in ascending order of the weight of the edge
            Collections.sort(edges, Comparator.comparingInt(e -> e[2]));
            
            // for each edge, do:
                // check of it both nodes belogs to the same set,
                    // if they do, then continue
                    // otherwise unite them to disjoint set and add weight to the ans;
                    
            DisjointSet ds = new DisjointSet(V);
            int ans = 0;
            for(int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                
                int pu = ds.findParent(u);
                int pv = ds.findParent(v);
                
                if(pu == pv) continue;
                
                else {
                    ds.unionBySize(u, v);
                    ans += w;
                }
            }
            
            return ans;
            
        }
    }