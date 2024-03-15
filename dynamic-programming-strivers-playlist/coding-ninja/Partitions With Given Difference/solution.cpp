// problem link: https://www.codingninjas.com/studio/problems/partitions-with-given-difference_3751628?leftPanelTabValue=PROBLEM

#include <bits/stdc++.h> 

int solveRecursive( int i, int k, int n, vector<int> &arr){ //will count number of subsets with given sum

     if( i==0) return 0 == k;

     return solveRecursive(i-1, k, n, arr) + solveRecursive(i-1, k-arr[i-1], n, arr);
}

int solveTabulated(int n, int k, vector<int> &arr) {
    vector<vector<int>> dp(n+1, vector<int>(k+1));
    dp[0][0] = 1;

    for(int i=1; i<=n; i++ ){
        for(int j=0; j<=k; j++){
            dp[i][j] = dp[i-1][j];
            if(arr[i-1] <= j) {
                dp[i][j] += dp[i-1][j-arr[i-1]];
                dp[i][j] %= 1000000007;
            }
        }
    }

    return dp[n][k];
}

int countPartitions(int n, int d, vector<int> &arr) {
    // Write your code here.
    int sum  = 0;
    for(int i=0; i<n; i++) {
        sum += arr[i];
    }

    /*S1 >= S2, then 
    S1 + S2 = sum
    S1 - S2 = d
    ----------------
    S1 = (sum+d)/2
    */
    if((sum+d)%2) return 0;
    int s1 = (sum + d )/2; 

    // return solveRecursive(n, s1, n, arr); 
    return solveTabulated(n, s1, arr);
}


