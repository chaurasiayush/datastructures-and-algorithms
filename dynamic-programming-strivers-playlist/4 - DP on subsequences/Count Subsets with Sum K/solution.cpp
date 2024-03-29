// problem link: https://www.codingninjas.com/studio/problems/count-subsets-with-sum-k_3952532?leftPanelTabValue=SUBMISSION

int solveRecursive(int i, vector<int>arr, int k) {
	if( k == 0 ) {
		return 1;
	}
	
	if( i==0 ) {
		return arr[0] == k;
	}	
    //      not taken                       taken
	return solveRecursive(i-1, arr, k) + solveRecursive(i-1, arr, k-arr[i]);
}

int solveTabulated( vector<int>&arr, int k) {
	
	int n = arr.size();
	vector<vector<long>> dp(n+1, vector<long>(k+1, 0));

	// for size zero and required sum 0, one way is possible 
	dp[0][0] = 1;
	
	for(int i=1; i<=n; i++) {
		for(int j=0; j<=k; j++) {
			dp[i][j] = dp[i-1][j];

			// if last element is less or equal to required sum, then take it
			if(arr[i-1] <= j) {
				dp[i][j] += dp[i-1][j-arr[i-1]];

				dp[i][j] %= 1000000007;
			}
		}
	}

	return dp[n][k];
}
int findWays(vector<int>& arr, int k)
{
	// Write your code here.
	int n = arr.size();
	// return solveRecursive(n-1, arr, k);
	return solveTabulated(arr, k);
}
