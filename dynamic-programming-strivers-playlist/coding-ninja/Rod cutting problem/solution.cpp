// problem link: https://www.codingninjas.com/studio/problems/rod-cutting-problem_800284?leftPanelTabValue=SUBMISSION

int solveTabulated(vector<int> &price, int n){

	vector<int>dp(n+1);
	dp[0] = 0;
	for(int i=1; i<=n; i++){
		int maxi=0;
		for(int j=0; j<n; j++){
			if(i>j){
				maxi = max(maxi, dp[i-j-1]+price[j]);
			}
		}
		dp[i] = maxi;
	}

	return dp[n];

    /*
        Time Complexity: O(n)?
        Space Complexity: O(n)
    */
}


int solveRecursive(vector<int> &price, int n) {
	// base case
	if(n==0) return 0;

	int maxi = 0;
	for(int i=0; i<n; i++){
		maxi = max(maxi, price[i] + solveRecursive(price, n-i-1));
	}

	return maxi;

    /*
        Time Complexity: O(n^2)
        Space Complexity: O(n)
    */
}

int solveMemoised(vector<int> &price, int n, vector<int>&dp) {
	// base case
	if(n==0) return 0;

	if(dp[n] != -1) return dp[n];
	int maxi = 0;
	for(int i=0; i<n; i++){
		maxi = max(maxi, price[i] + solveMemoised(price, n-i-1, dp));
	}

	return dp[n] = maxi;

    /*
        Time Complexity: O(n);
        Space Complexity: O(n) + O(n) - stack space;
    */
}

int cutRod(vector<int> &price, int n)
{
	// Write your code here.
	// return solveRecursive(price, n);

	vector<int>dp(n+1, -1);
	return solveMemoised(price, n, dp);
	// return solveTabulated(price, n);
}
