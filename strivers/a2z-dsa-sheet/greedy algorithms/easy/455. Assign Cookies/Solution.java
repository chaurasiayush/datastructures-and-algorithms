//link: https://leetcode.com/problems/assign-cookies/description/

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //first sort the cookie array and children greed array
        Arrays.sort(g);
        Arrays.sort(s);

        int ci = 0, gi = 0;
        int count = 0;
        while(ci < s.length && gi < g.length) {
            if(s[ci] >= g[gi]) {
                count++;
                ci++;
                gi++;
            } else {
                ci++;
            }
        }

        return count;   
    }
}