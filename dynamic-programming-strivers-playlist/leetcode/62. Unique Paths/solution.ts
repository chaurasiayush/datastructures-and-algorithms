function uniquePaths(m: number, n: number): number {

    function solveRecursive(row, col) : number {
        if(row < 0 || col < 0) return 0;

        if(row == 0 && col == 0) return 1;

        return solveRecursive(row-1, col) + solveRecursive(row, col-1);

        /*
            Time Complexity: O(2^mxn)
            Space Complexity: O((m-1) + (n-1)) -> stack space
        */
    } 


    const dp = Array(m).fill(Array(n).fill(-1));
    function solveMemoized(row, col) : number {
        if(row < 0 || col < 0) return 0;

        if(row == 0 && col == 0) return 1;

        if(dp[row][col] != -1) return dp[row][col];

        dp[row][col] = solveRecursive(row-1, col) + solveRecursive(row, col-1);
        return dp[row][col];

        /*
            Time Complexity: O(m x n)
            Space Complexity: O(m x n) + O((m-1)+(n-1)) -> stack space
        */
    } 

    function solveTabulated(rows, cols): number {
        const dp = Array(m).fill(Array(n).fill(0));
        dp[0][0] = 1;

        for(let i=0; i<rows; i++) {
            for(let j=0; j<cols; j++){
                if(i==0 && j==0) continue;
                if(i > 0) {
                    dp[i][j] = dp[i-1][j];
                }

                if(j > 0) {
                    dp[i][j] += dp[i][j-1];
                }
            }
        }

        return dp[rows-1][cols-1];

        /*
            Time Complexity: O(m x n)
            Space Complexity: O(m x n)
        */
    }

    function solveTabulatedSpaceOptimised(rows, cols): number {
    let prev = Array(cols).fill(0);
    let curr = Array(cols).fill(0);

    for(let i=0; i<rows; i++) {
        for(let j=0; j<cols; j++){
            if(i==0 && j==0) curr[j] = 1;
            if(i > 0) {
                curr[j] = prev[j];
            }

            if(j > 0) {
                curr[j] += curr[j-1];
            }
        }
        prev = curr;
    }

        return prev[cols-1];

        /*
            Time Complexity: O(m x n)
            Space Complexity: O(2n)
        */
    }

    // return solveRecursive(m-1, n-1);  
    // return solveMemoized(m-1, n-1); 
    // return solveTabulated(m, n)
    return solveTabulatedSpaceOptimised(m, n);
};
