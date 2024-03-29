// problem link: https://www.codingninjas.com/studio/problems/chocolate-pickup_3125885?leftPanelTabValue=PROBLEM

#include <bits/stdc++.h> 

int solveRecursive(int i, int j1, int j2, int r, int c, vector<vector<int>> &grid) {

    if(j1 <0 || j1 >=c || j2 < 0 || j2 >= c) {
        return -1e9;
    }

    if(i == r-1) {
        if (j1 == j2) {
          return grid[i][j1];
        }

        return grid[i][j1] + grid[i][j2];
    }
    int directions[] = {-1, 0, 1};
    int maxi = -1e9;
    for(int k1=0; k1<3; k1++){
        for(int k2=0; k2<3; k2++){
            if(j1 == j2){
                maxi = max(maxi, grid[i][j1] + solveRecursive(i+1, j1+directions[k1], j2+directions[k2], r, c, grid));
            }else {
                maxi = max(maxi, grid[i][j1] + grid[i][j2] + solveRecursive(i+1, j1+directions[k1], j2+directions[k2], r, c, grid));
            }
        }
    }
    return maxi;
}

int solveMemoised(int i, int j1, int j2, int r, int c, vector<vector<int>> &grid, vector<vector<vector<int>>> &dp) {

    if(j1 <0 || j1 >=c || j2 < 0 || j2 >= c) {
        return -1e9;
    }

    if(i == r-1) {
        if (j1 == j2) {
          return grid[i][j1];
        }

        return grid[i][j1] + grid[i][j2];
    }

    if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

    int directions[] = {-1, 0, 1};
    int maxi = -1e9;
    for(int k1=0; k1<3; k1++){
        for(int k2=0; k2<3; k2++){
            if(j1 == j2){
                maxi = max(maxi, grid[i][j1] + solveMemoised(i+1, j1+directions[k1], j2+directions[k2], r, c, grid, dp));
            }else {
                maxi = max(maxi, grid[i][j1] + grid[i][j2] + solveMemoised(i+1, j1+directions[k1], j2+directions[k2], r, c, grid, dp));
            }
        }
    }
    return dp[i][j1][j2] = maxi;
}

int solveTabulated(int r, int c, vector<vector<int>> &grid) {
    vector<vector<vector<int>>> dp(r, vector<vector<int>>(c, vector<int>(c, -1e9)));


    for(int j1=0; j1<c; j1++){
        for(int j2=0; j2<c; j2++){
            if(j1 == j2 ){
                dp[r-1][j1][j2] = grid[r-1][j1];
            } else{
                dp[r-1][j1][j2] = grid[r-1][j1]+grid[r-1][j2];
            }
        }
    }

    for(int i=r-2; i>=0; i--){
        for(int j1=0; j1<c; j1++) {
            for(int j2=0; j2<c; j2++){

                //try all 9 possible ways
                int maxi = -1e9;
                for(int dj1=-1; dj1<=1; dj1++) {
                    for(int dj2 =-1; dj2<=1; dj2++){
                        // validate for path
                        if(j1+dj1 >= 0 && j1+dj1 < c && j2+dj2>=0 && j2+dj2 < c){
                            maxi = max(maxi, dp[i+1][j1+dj1][j2+dj2]);
                        }
                    }
                }

                if(j1 == j2) {
                    maxi += grid[i][j1];
                } else {
                    maxi += (grid[i][j1] + grid[i][j2]);
                }

                dp[i][j1][j2] = maxi;
            }
        }
    }

    int ans=0;
    for(int j1=0; j1<c; j1++){
        for(int j2=0; j2<c; j2++){
            ans = max(ans, dp[0][j1][j2]);
        }
    }

    return dp[0][0][c-1];
}

int maximumChocolates(int r, int c, vector<vector<int>> &grid) {
    // Write your code here.
    // vector<vector<vector<int>>> dp(r, vector<vector<int>>(c, vector<int>(c, -1)));
    // return solveMemoised(0, 0, c-1, r, c, grid, dp);
    return solveTabulated(r, c, grid);
}