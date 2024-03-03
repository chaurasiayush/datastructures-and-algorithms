function rob(nums: number[]): number {
    const n = nums.length;

    //recusive solution
    function solveRecursive(i: number) : number {
        if(i < 0) return 0;

        let pick = nums[i] + solveRecursive(i-2);
        let notPick = solveRecursive(i-1);

        return Math.max(pick, notPick);
    }

    const dp = Array(n).fill(-1);
    function solveMemoization(i: number) : number {
        if(i < 0) return 0;

        if(dp[i] != -1) return dp[i];

        let pick = nums[i] + solveRecursive(i-2);
        let notPick = solveRecursive(i-1);

        return dp[i] = Math.max(pick, notPick);
    }

    function solveTabulation(i: number): number {
        const dp = Array(n);
        dp[0] = nums[0];

        for(let i=1; i<n; i++){
            let pick = nums[i];
            if(i>1) {
                pick += dp[i-2]; 
            }
            let notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }

    function solveTabulationOptimized(i: number) : number {
        let previous = nums[0];
        let previousToPrevious = 0;
        let current = 0;

        for(let i=1; i<n; i++){
            let pick = nums[i] + previousToPrevious;
            let notPick = previous;
            current = Math.max(pick, notPick);

            previousToPrevious = previous;
            previous = current;
        }

        return previous;
    }

    // return solveRecursive(n-1);  
    // return solveMemoization(n-1);  
    // return solveTabulation(n-1);  
    return solveTabulationOptimized(n-1);
};
