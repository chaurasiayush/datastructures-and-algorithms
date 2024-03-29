// problem link: https://leetcode.com/problems/coin-change-ii/

function change(amount: number, coins: number[]): number {
    
    const n = coins.length;

    function solveRecursive(i: number, k: number): number {
        // if k (target amount) is zero, then one way is possible -> do not take any coin
        if(k == 0) return 1;
        
        // if there are no coins and k is non zero, no pssible ways
        if(i==0) return 0;

        // if we take the coin, we can again take it since there is unlimited supply
        // if we do not take it, we won't be taking this coin again in future

        let ans = solveRecursive(i-1, k);
        if(k >= coins[i-1]) {
            ans += solveRecursive(i, k-coins[i-1]);
        }
        return ans;
    }

    function solveTabulated() : number {
        const dp = Array(n+1).fill(null).map(() => new Array(amount+1).fill(0));

        // if amount is zero then there is one possible way that is to not take any coin
        dp[0][0] = 1;

        for(let i=1; i<=n; i++) {
            for(let j=0; j<=amount; j++) {
                // do not choose current coin
                dp[i][j] = dp[i-1][j];

                // if current coin is not greater than required, take it
                if(coins[i-1] <= j) {
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }
        }

        // NOTE: it can also be solved using a loop from 1 to n, because each step we have n choices;

        return dp[n][amount];
    }

    // return solveRecursive(n, amount);
    return solveTabulated();
};