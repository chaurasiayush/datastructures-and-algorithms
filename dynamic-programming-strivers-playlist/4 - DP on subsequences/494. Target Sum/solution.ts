// problem link: https://leetcode.com/problems/target-sum/

function findTargetSumWays(nums: number[], target: number): number {
    const n = nums.length;

    function solveRecursive(i: number, target: number) : number {
        // base case
        if(i==0) return target? 0 : 1;

        return solveRecursive(i-1, target-nums[i-1]) + solveRecursive(i-1, target+nums[i-1]);
    }

    function solveMemoised(i: number, target: number, dp:Map<number, number>[]) : number {
        // base case
        if(i==0) return target? 0 : 1;

        if(dp[i].has(target)) return dp[i].get(target) as number;
        dp[i].set(target, solveMemoised(i-1, target-nums[i-1], dp) + solveMemoised(i-1, target+nums[i-1], dp));
        return dp[i].get(target) as number;
    }

    function solveTabulated(): number {
        const dp = Array(n+1).fill(null).map(() => new Map<number, number>());
        dp[0].set(0, 1);

        let minTarget=0, maxTarget=0;
        nums.forEach((num) => {
            minTarget -= num;
            maxTarget += num;
        })

        for(let i=1; i<=n; i++) {
            for(let j=minTarget; j<=maxTarget; j++){
                let added=0, substracted=0, ans=0;
                if(dp[i-1].get(j-nums[i-1])){
                    ans += dp[i-1].get(j-nums[i-1]) as number;
                }

                if(dp[i-1].get(j+nums[i-1])){
                    ans += dp[i-1].get(j+nums[i-1]) as number;
                }
                // console.log(ans);
                dp[i].set(j, ans);
                // }
            }
        }
        // console.log(dp);
        return dp[n].get(target)??0;
    }

    /*
        out of the box solution:
        now since we can assign plus or minus sign to every element, some element is going to
        be negativeit and some positive, therefore is similar to diving array into two subarrays
        S1, S2 such that S1 - S2 = target
        since S1 + S2 = total_sum
        S1 = (target + S2)/2
    */

    function findSubsetsWithTarget(k: number, i: number): number {
        const dp = Array(n+1).fill(null).map(() => new Array(k+1).fill(0));
        dp[0][0] = 1;

        for(let i=1; i<=n; i++) {
            for(let j=0; j<=k; j++){
                // if we do not take current element
                dp[i][j] = dp[i-1][j];
                
                // if current element is not greater than target sum, and we take it
                if(nums[i-1] <= j){
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[n][k];
    }

    const sum = nums.reduce((e, prev) => e + prev);
    if((sum+target) % 2 != 0 || (sum+target) < 0 ) return 0;
    const k = (sum+target)/2;
    return findSubsetsWithTarget(k, n);

    // const dp = Array(n+1).fill(null).map(() =>new Map<number, number>())
    // const dp =  new Map<number, number>();
    // return solveRecursive(n, target);
    // return solveMemoised(n, target, dp);
    // return solveTabulated();
};