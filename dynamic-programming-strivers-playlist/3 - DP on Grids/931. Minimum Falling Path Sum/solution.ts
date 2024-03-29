// problem link: https://leetcode.com/problems/minimum-falling-path-sum/description/

function minFallingPathSum(matrix: number[][]): number {
    const n = matrix.length;
    
    function solveRecursive(row, col) {
        if(col >= n || col < 0) {
            return Number.MAX_VALUE //Number.MAX_SAFE_INTEGER;
        }

        if(row === 0) {
            return matrix[row][col];
        }

        let p1 = Number.MAX_VALUE; //p2 =  p3 = 0;
        if(col > 0) {
            p1 = matrix[row][col] + solveRecursive(row-1, col-1);
        }
        if(col < n) {
            p1 = Math.min(p1, matrix[row][col] + solveRecursive(row-1, col+1));
        }
        p1 = Math.min(p1, matrix[row][col] + solveRecursive(row-1, col));
        return p1;
        /*
            Time Complexity: O(3^m)
            Space Complexity: O(m)
        */
    }

    function solveMemoized(row, col) {
        if(col >= n || col < 0) {
            return Number.MAX_VALUE //Number.MAX_SAFE_INTEGER;
        }

        if(row === 0) {
            return matrix[row][col];
        }

        if(dp[row][col] != Number.MAX_VALUE) return dp[row][col];

        let p1 = Number.MAX_VALUE; //p2 =  p3 = 0;
        if(col > 0) {
            p1 = matrix[row][col] + solveRecursive(row-1, col-1);
        }
        if(col < n) {
            p1 = Math.min(p1, matrix[row][col] + solveRecursive(row-1, col+1));
        }
        p1 = Math.min(p1, matrix[row][col] + solveRecursive(row-1, col));
        return dp[row][col] = p1;
        /*
            Time Complexity: O(n x n)
            Space Complexity: O(n) + O(n x n): stack space + dp
        */
    }

    function solveTabulated() {
        const dp = Array(n).fill(null).map(() => new Array(n).fill(0));

        for(let i=0; i<n; i++) {
            for(let j=0; j<n; j++) {
                if(i==0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    let tmp = dp[i-1][j];
                    if(j>0) tmp = Math.min(tmp, dp[i-1][j-1]);
                    if(j<n-1) tmp = Math.min(tmp, dp[i-1][j+1]);
                    dp[i][j] = tmp + matrix[i][j];
                }
            }
        }

        return Math.min(...dp[n-1]);

        /*
            Time Complexity: O(n x n)
            Space Complexity: O(n x n)
        */
    }

    function solveTabulatedOptimised() {
        let prev = Array.from(matrix[0]);

        // console.log(prev)

        for(let i=1; i<n; i++) {
            let curr:number[] = [];
            for(let j=0; j<n; j++) {
                if(i==0) {
                    curr[j] = matrix[i][j];
                } else {
                    let tmp = prev[j];
                    if(j>0) tmp = Math.min(tmp, prev[j-1]);
                    if(j<n-1) tmp = Math.min(tmp, prev[j+1]);
                    curr[j] = tmp + matrix[i][j];
                }
            }
            prev = curr
            // console.log(prev);
        }

       return Math.min(...prev);

        /*
            Time Complexity: O(n x n)
            Space Complexity: O(n)
        */
    }

    let dp;
    // dp = Array(n).fill(null).map(() => new Array(n).fill(Number.MAX_VALUE));
    // let ans = Number.MAX_VALUE;
    // matrix[n-1].forEach((_, i) => {
    //     ans = Math.min(ans, solveMemoized(n-1, i));
    // })
    // return ans;

    return solveTabulatedOptimised();

};

function main() {
    const matrix = [[2,1,3],[6,5,4],[7,8,9]];
    const ans = minFallingPathSum(matrix);

    console.log('ans', ans);
}

main();