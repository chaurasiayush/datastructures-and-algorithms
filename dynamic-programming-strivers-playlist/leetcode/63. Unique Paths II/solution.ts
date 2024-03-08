// problem link: https://leetcode.com/problems/unique-paths-ii/

function uniquePathsWithObstacles(obstacleGrid: number[][]): number {
    const m = obstacleGrid.length;
    const n = obstacleGrid[0].length;

    function solveRecursive(row, col) : number {
        // base case
        if(row === 0 && col === 0) {
            if(obstacleGrid[row][col] != 1) {
                // found one possible way
                return 1;
            }

            return 0;
        } 

        if(row >= 0 && col >= 0) {
            if(obstacleGrid[row][col] != 1) {
                return solveRecursive(row-1, col) + solveRecursive(row, col-1);
            }
        }

        return 0;

        /*
            Time Complexity: O(2 ^ (n x m))
            Space Complexity: O(m-1 + n-1)
        */
    }

    const dp = Array(m).fill(Array(n).fill(-1));
    function solveMemoized(row, col) : number {
        // base case
        if(row === 0 && col === 0) {
            if(obstacleGrid[row][col] != 1) {
                // found one possible way
                return 1;
            }

            return 0;
        } 
        if(row >= 0 && col >= 0) {
            if(dp[row][col] != -1){
                return dp[row][col];   
            }
            if(obstacleGrid[row][col] != 1) {
                return dp[row][col] = solveRecursive(row-1, col) + solveRecursive(row, col-1);
            }
        }

        return 0;
        
        /*
            Time Complexity: O(m x n)
            Space Complexity: O(m x n) + O((m-1)+(n-1)) -> stack space
        */
    }

    function solveTabulated() {
        let tbl = new Array(m).fill(0);
        tbl = tbl.map(row => {
            return new Array(n).fill(0);
        })
        if(obstacleGrid[0][0] == 1) return 0;
        tbl[0][0] = 1;

        for(let i=0; i<m; i++){
            for(let j=0; j<n; j++){

                if(i==0 && j==0) continue;

                else if(obstacleGrid[i][j] != 1) {
                    if(i > 0) {
                        tbl[i][j] += tbl[i-1][j];
                    }
                    if(j > 0) {
                        tbl[i][j] += tbl[i][j-1];
                    }
                }
            }
        }
        return tbl[m-1][n-1];
    }

    // return solveMemoized(m-1, n-1);
    return solveTabulated();
};