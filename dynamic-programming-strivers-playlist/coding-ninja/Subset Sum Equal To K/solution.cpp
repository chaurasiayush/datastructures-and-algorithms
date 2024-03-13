//problem link: https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954?leftPanelTabValue=PROBLEM

#include <bits/stdc++.h> 

bool solveMemoised(int i, int n, int k, vector<int> &arr, vector<vector<int>> dp){
    if(k == 0) return true;
    if(i>= n || k < 0) return false;

    if(dp[i][k] != -1) return dp[i][k];

    bool res = solveMemoised(i+1, n, k-arr[i], arr, dp) || solveMemoised(i+1, n, k, arr, dp);
    dp[i][k] = res;
    return res;
}

bool solveRecursive(int i, int n, int k, vector<int> &arr, vector<vector<int>> dp){
    if(k == 0) return true;
    if(i>= n || k < 0) return false;

    bool res = solveRecursive(i+1, n, k-arr[i], arr, dp) || solveRecursive(i+1, n, k, arr, dp);
    return res;
}

bool solveTabulated(int n, int k, vector<int> &arr) {
     vector < vector < bool >> dp(n, vector < bool > (k + 1));

    // If required price = 0, answer always true.
    for (int i = 0; i < n; i++) {
        dp[i][0] = true;
    }

    dp[0][arr[0]] = true;

    // Filling dp array.
    for (int i = 1; i < n; i++) {
        for (int j = 1; j <= k; j++) {
            dp[i][j] = dp[i - 1][j];
            if (arr[i] <= j) {
                dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i]];
            }
        }
    }

    return dp[n-1][k];
}

bool subsetSumToK(int n, int k, vector<int> &arr) {
    // Write your code here
    // vector<vector<int>> dp(n, vector<int>(k+1, -1));
    // return solveRecursive(0, n, k, arr, dp);
    return solveTabulated(n, k, arr);
}
