// Link: https://leetcode.com/problems/number-of-operations-to-make-network-connected/
class Solution {

    // first approach is to findout if this is possible by calculating the difference
    // between MST edges and present edges then count connected compoenents using bfs
    // traversal and then find out no of required edges to connect then together, check
    // if we have that much extera edges and return ans

    private static void bfs(int src, int[] visited, ArrayList<Integer>[] adj){
        visited[src] = 1;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(src);

        while(!q.isEmpty()) {
            int cnode = q.poll();
            for(int node : adj[cnode]) {
                if(visited[node] == 0) {
                    q.add(node);
                    visited[node] = 1;
                }
            }
        }
    }

    public int makeConnected2(int n, int[][] connections) {
        int noOfEdges = connections.length;
        
        if(noOfEdges < n-1) return -1;

        int[] visited = new int[n];
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<noOfEdges; i++) {
            int[] edge = connections[i];
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int count = 0;
        for(int i=0; i<n; i++){
            if(visited[i] == 0){
                count++;
                bfs(i, visited, adj);
            }
        }

        return count-1;
    }

    //second approach is to use disjoint sets
    // whenever on the union we find that nodes are already connected, we can count it as an extra edge
    // count components by checking nodes having parent same as themselves

    private class DisjointSets {
        int[] parent;
        int[] size;

        public DisjointSets(int n) {
            parent = new int[n];
            // set parent to themselves
            for(int i=0; i<n; i++){
                parent[i] = i;
            }

            size = new int[n];
        }

        public int findParent(int node) {
            if(parent[node] == node) return node;
            int np = findParent(parent[node]);
            parent[node] = np;
            return np;
        }

        public int union(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

            if(pu == pv) return 1;

            if(size[pu] > size[pv]) {
                parent[pv] = pu;
            } else if(size[pv] > size[pu]) {
                parent[pu] = pv;
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
            return 0;
        }

        public int countComponents() {
            int count = 0;
            for(int i=0; i<parent.length; i++) {
                if(parent[i] == i) count++;
            }
            return count;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        int noOfEdges = connections.length;
        DisjointSets ds = new DisjointSets(n);

        int count = 0;
        for(int i=0; i<noOfEdges; i++){
            int[] edge = connections[i];
            count += ds.union(edge[0], edge[1]);
        }

        int comps = ds.countComponents();
        if(count >= comps - 1) return comps-1;

        return -1;

    }
}