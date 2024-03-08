// problem link: https://leetcode.com/problems/minimum-path-sum/

function minPathSum(grid: number[][]): number {
    const m = grid.length;
    const n = grid[0].length;
    function solveRecursive(row, col): number {
        if(row == 0 && col == 0) {
            return grid[row][col];
        }

        if(row >= 0 && col >= 0) {
            return grid[row][col] + Math.min(solveRecursive(row, col-1), solveRecursive(row-1, col));
        }

        return Number.MAX_SAFE_INTEGER;
    }

    const dp = Array(m).fill(null).map(() => new Array(n).fill(-1));
    function solveMemoized(row, col): number {
        if(row == 0 && col == 0) {
            return grid[row][col];
        }

        if(row >= 0 && col >= 0) {
            if(dp[row][col] != -1) return dp[row][col];
            return dp[row][col] = grid[row][col] + Math.min(solveRecursive(row, col-1), solveRecursive(row-1, col));
        }

        return Number.MAX_SAFE_INTEGER;
    }

    function solveTabulated() {
        const dp = Array(m).fill(null).map(() => new Array(n).fill(0));
        dp[0][0] = grid[0][0];

        for(let i=0; i<m; i++){
            for(let j=0; j<n; j++){
                if(i==0&&j==0) continue;
                
                dp[i][j] = grid[i][j];
                let tmp = Number.MAX_VALUE;
                if(i>0) {
                    tmp = Math.min(tmp,dp[i-1][j]);
                }

                if(j>0) {
                    tmp = Math.min(tmp, dp[i][j-1]);
                }
                dp[i][j] += tmp;
            }
        }

        return dp[m-1][n-1];
    }

    function solveTabulatedOptimised() {
        const prev = new Array(n).fill(0);
        const curr = new Array(n).fill(0);

        curr[0] = grid[0][0]

        for(let i=0; i<m; i++){
            for(let j=0; j<n; j++){
                if(i==0&&j==0) continue;
                
                curr[i] = grid[i][j];
                let tmp = Number.MAX_VALUE;
                if(i>0) {
                    tmp = Math.min(tmp,prev[j]);
                }

                if(j>0) {
                    tmp = Math.min(tmp,curr[j-1]);
                }
                curr[i] += tmp;
            }
        }

        return prev[n-1];
    }

    // return solveMemoized(m-1, n-1);
    return solveTabulated();
};