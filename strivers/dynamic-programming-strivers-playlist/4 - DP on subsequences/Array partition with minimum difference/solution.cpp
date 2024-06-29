//problem link: https://www.codingninjas.com/studio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum._842494?leftPanelTabValue=PROBLEM

int solveTabulated(vector<int> &arr, int n) {
	int sum = 0;
	for(int i=0; i<n; i++) {
		sum += arr[i];
	}

	// if(sum % 2) return false;
	int target = sum;

	vector<vector<bool>> dp(n, vector<bool>(target+1, false));
	
	for(int i=0; i<n; i++) dp[i][0] = true;
	dp[0][arr[0]] = true;
	
	for(int i=1; i<n; i++) {
		for(int k=1; k<=target; k++){
			dp[i][k] = dp[i-1][k];
			 if(arr[i] <= k) {
				dp[i][k] = dp[i-1][k] | dp[i-1][k-arr[i]];
			}
		}
	}

	int mini = 1e9;
	for(int i=0; i<=target; i++){
		if(dp[n-1][i]) {
			mini = min(mini, abs(2*i-sum));
		}
	}

	return mini;
}


int minSubsetSumDifference(vector<int>& arr, int n)
{
	return solveTabulated(arr, n);
}
