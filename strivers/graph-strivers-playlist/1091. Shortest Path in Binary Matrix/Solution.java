//Link: https://leetcode.com/problems/shortest-path-in-binary-matrix/

import java.util.*;
class Solution {

    private static class Pair {
        int row;
        int col;
        int dist;

        public Pair(int row, int col, int dis) {
            this.row = row;
            this.col = col;
            this.dist = dis;
        }
    }

    public static int djisktra(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1; 

        int[][] paths = new int[m][n];

        for(int i=0; i<m; i++){
            int row[] = new int[n];
            Arrays.fill(row, Integer.MAX_VALUE);
            paths[i] = row;
        }

        paths[0][0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.dist - b.dist);
        pq.add(new Pair(0, 0, 1));

        int[] rowdirs = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] coldirs = {0, 0, -1, 1, -1, 1, 1, -1};

        while(!pq.isEmpty()) {
            Pair node = pq.poll();

            for(int i=0; i<8; i++){
                int row = node.row + rowdirs[i];
                int col = node.col + coldirs[i];

                if(row >=0 && row <m && col >=0 && col <n) {
                    if(grid[row][col] == 0 && paths[row][col] > node.dist + 1) {
                        paths[row][col] = node.dist + 1;
                        pq.add(new Pair(row, col, paths[row][col]));
                    }
                }
            }
        }

        return paths[m-1][n-1] == Integer.MAX_VALUE ? -1 : paths[m-1][n-1];

    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        return djisktra(grid);
    }
}