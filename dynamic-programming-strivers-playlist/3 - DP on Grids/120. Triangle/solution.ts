// problem link: https://leetcode.com/problems/triangle/

function minimumTotal(triangle: number[][]): number {

    const n = triangle.length;
    function solveRecursive(row, col) {
        if (row === 0) return triangle[0][0];

        let tmp = Number.MAX_VALUE;
        if (col <= row) {
            tmp = solveRecursive(row - 1, col);
            if (col > 0) {
                tmp = Math.min(tmp, solveRecursive(row - 1, col - 1));
            }
            tmp += triangle[row][col];
        }
        return tmp;

    }
    const dp = Array(n).fill(null).map((_, i) => new Array(i + 1).fill(Number.MAX_VALUE));
    function solveMemoized(row, col) {
        if (row === 0) return triangle[0][0];

        let tmp = Number.MAX_VALUE;

        if (dp[row][col] != Number.MAX_VALUE) return dp[row][col];

        if (col <= row) {
            tmp = solveRecursive(row - 1, col);
            if (col > 0) {
                tmp = Math.min(tmp, solveRecursive(row - 1, col - 1));
            }
            tmp += triangle[row][col];
        }
        return dp[row][col] = tmp;

    }

    function solveTabulized() {
        const dp = Array(n).fill(null).map((_, i) => new Array(i + 1).fill(Number.MAX_VALUE));
        dp[0][0] = triangle[0][0];

        for (let i = 1; i < n; i++) {
            for (let j = 0; j <= i; j++) {


                if (j <= i) {
                    let tmp = Number.MAX_VALUE;
                    if( i-1 >= j) tmp = dp[i-1][j]
                    if (j > 0) {
                        tmp = Math.min(tmp, dp[i - 1][j - 1]);
                    }
                    dp[i][j] = tmp + triangle[i][j];
                }
            }
        }
        let ans = Number.MAX_VALUE;
        return Math.min(...dp[n - 1]);
    }

    // let ans = Number.MAX_VALUE;
    // triangle[n-1].forEach((row, index) => {
    //     let rm = solveMemoized(n-1, index);
    //     ans = Math.min(rm, ans);
    // })

    // return ans;
    return solveTabulized();
};