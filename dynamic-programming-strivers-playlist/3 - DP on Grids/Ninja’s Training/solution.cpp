// problem link:  https://bit.ly/3F4yl8z

int solveRecursive(int n, vector<vector<int>> &points, vector<vector<int>> &dp,int prevActivity,int currentDay) {
    if( currentDay < 0) return 0;

    int curMax = -1;
    int pick;
    if(dp[currentDay][prevActivity] != -1) return dp[currentDay][prevActivity];
    for(int i=0; i<3; i++){
        if(i == prevActivity) continue;
        pick = points[currentDay][i] + solveRecursive(n, points,dp, i, currentDay-1);
        curMax = max(curMax, pick);
    }

    dp[currentDay][prevActivity] = curMax;
    return curMax;
}

//strivers solution
int solveTabulated(int n, vector<vector<int>> &points){
    vector<vector<int>> dp(n, vector<int>(4,0));

    dp[0][0] = max(points[0][1],points[0][2]);
    dp[0][1] = max(points[0][0],points[0][2]);
    dp[0][2] = max(points[0][1],points[0][0]);
    dp[0][3] = max(points[0][0], max(points[0][1], points[0][2]));

    for(int day=1; day<n; day++){
        for(int prevActivity=0; prevActivity<4; prevActivity++){
            dp[day][prevActivity] = 0;
            for (int task = 0; task < 3; task++) {
                if(task == prevActivity) continue;
                dp[day][prevActivity] = max(dp[day][prevActivity], points[day][task]+dp[day-1][task]);
            }
        }
    }

    return dp[n-1][3];
}

int solveTabulatedMy(int n, vector<vector<int>> &points){
    vector<vector<int>> dp(n+1, vector<int>(4,0));

    // dp[0] = [0,0,0,0];

    for(int day=1; day<=n; day++){
        for(int prevActivity=0; prevActivity<4; prevActivity++){
            dp[day][prevActivity] = 0;
            for (int task = 0; task < 3; task++) {
                if(task == prevActivity) continue;
                dp[day][prevActivity] = max(dp[day][prevActivity], points[day-1][task]+dp[day-1][task]);
            }
        }
    }

    return dp[n][3];
}

int ninjaTraining(int n, vector<vector<int>> &points)
{
    // Write your code here.
    // vector<vector<int>> dp(n, vector<int>(4,-1));
    // return solveRecursive(n, points,dp, 3, n-1);
    return solveTabulatedMy(n, points);
}
