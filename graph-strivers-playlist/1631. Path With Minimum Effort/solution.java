// Link: https://leetcode.com/problems/path-with-minimum-effort/description/

import java.util.*;
class Solution {

    private static class Pair {
        int row, col, efforts;

        private Pair(int row, int col, int efforts) {
            this.row = row;
            this.col = col;
            this.efforts = efforts;
        }
    }

    private static int djisktra(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int paths[][] = new int[m][n];

        for(int i=0; i<m; i++) {
            paths[i] = new int[n];
            Arrays.fill(paths[i], (int)(1e9));
        }

        paths[0][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.efforts - b.efforts);
        pq.add(new Pair(0, 0, 0));

        int[] rowdirs = {-1, 1, 0, 0};
        int[] coldirs = {0, 0, -1, 1};

        while(!pq.isEmpty()) {
            Pair node = pq.poll();
            for(int i=0; i<4; i++) {
                int row = node.row + rowdirs[i];
                int col = node.col + coldirs[i];

                if(row >= 0 && row < m && col >=0 && col < n) {
                    // required efforts = max (global max effort, current effort)
                    int requiredEfforts = Math.max(node.efforts, Math.abs(heights[node.row][node.col] - heights[row][col]));
                    if(paths[row][col] > requiredEfforts) {
                        paths[row][col] = requiredEfforts;
                        pq.add(new Pair(row, col, requiredEfforts));
                    }
                }
            }
        }

        return paths[m-1][n-1];
    }

    public int minimumEffortPath(int[][] heights) {
        return djisktra(heights);
    }
}