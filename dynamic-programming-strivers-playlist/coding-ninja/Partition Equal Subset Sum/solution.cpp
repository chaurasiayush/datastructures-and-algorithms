// problem link: https://www.codingninjas.com/studio/problems/partition-equal-subset-sum-_892980

bool solveRecursive(vector<int> &arr, int n, int sum) {
	if(sum == 0) return true;
	if(n < 0 || sum < 0) return false;

	return solveRecursive(arr, n-1, sum-arr[n]) || solveRecursive(arr, n-1, sum);
}

bool solveTabulated(vector<int> &arr, int n) {
	int sum = 0;
	for(int i=0; i<n; i++) {
		sum += arr[i];
	}

	if(sum % 2) return false;
	int target = sum/2;

	vector<vector<bool>> dp(n, vector<bool>(target+1, false));
	
	for(int i=0; i<n; i++) dp[i][0] = true;
	// dp[0][arr[0]] = true;
	for(int i=1; i<n; i++) {
		for(int k=1; k<=target; k++){
			dp[i][k] = dp[i-1][k];
			 if(arr[i] <= k) {
				dp[i][k] = dp[i-1][k] | dp[i-1][k-arr[i]];
			}
		}
	}

	return dp[n-1][target];
}
bool canPartition(vector<int> &arr, int n)
{
	// Write your code here.
	// int sum = 0;
	// for(int i=0; i<n; i++) {
	// 	sum += arr[i];
	// }
	// int s = sum/2;
	// if(s*2 != sum ) return false;
	// return solveRecursive(arr, n-1, sum/2);
	return solveTabulated(arr, n);
}
