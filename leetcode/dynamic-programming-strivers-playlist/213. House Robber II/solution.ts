// problem link: https://leetcode.com/problems/house-robber-ii/description/

function rob2(nums: number[]): number {

    const n = nums.length;
    
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

    //case when there is only one element
    if(n === 1) return nums[0];

    const originalNums = nums;
    
    nums = originalNums.map((num, i) => i? num: 0 );
    const first = solveTabulationOptimized(n-1);
    
    nums = originalNums.map((num, i) => i===n-1? 0 : num );
    const second = solveTabulationOptimized(n-1)
    
    return Math.max(first, second);
}; 

