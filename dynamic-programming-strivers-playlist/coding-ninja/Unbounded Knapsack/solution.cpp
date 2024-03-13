// problem link: https://www.codingninjas.com/studio/problems/unbounded-knapsack_1215029?leftPanelTabValue=SUBMISSION

int solveRecursive(int n, int w, vector<int> &profit, vector<int> &weight){

    //base case 
    if(w == 0) {
        return 0;
    }

    int maxi = 0;
    for(int i=0; i<n; i++){
        if(weight[i] <= w) {
            maxi = max(maxi, profit[i] + solveRecursive(n, w-weight[i], profit, weight));
        }
    }

    return maxi;
}

int solveMemoised(int n, int w, vector<int> &profit, vector<int> &weight, vector<int> &dp){

    //base case 
    if(w == 0) {
        return 0;
    }

    if(dp[w] != -1) return dp[w];
    int maxi = 0;
    for(int i=0; i<n; i++){
        if(weight[i] <= w) {
            maxi = max(maxi, profit[i] + solveMemoised(n, w-weight[i], profit, weight, dp));
        }
    }

    return dp[w] = maxi;
}

int solveTabulated(int n, int w, vector<int> &profit, vector<int> &weight) {

    vector<int> dp(w+1);
    dp[0] = 0;

    for(int i=1; i<=w; i++ ){
        int maxi=0;
        for(int j=0; j<n; j++){
            if(i >= weight[j]){
                maxi = max(maxi, profit[j] + dp[i-weight[j]]);
            }
        }
        dp[i] = maxi;
    }
    return dp[w];
}

int unboundedKnapsack(int n, int w, vector<int> &profit, vector<int> &weight){
    // Write Your Code Here.
    // return solveRecursive(n, w, profit, weight);

    // vector<int> dp(w+1, -1);
    // return solveMemoised(n, w, profit, weight, dp);
    solveTabulated(n, w, profit, weight);
}