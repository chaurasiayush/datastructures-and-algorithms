//Link: https://leetcode.com/problems/task-scheduler/

import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> ncount = new HashMap<>();

        int maxCount = 0;
        int nmc = 0;

        // Count tasks
        for(char c: tasks) {
            int count = ncount.getOrDefault(c, 0) + 1;
            ncount.put(c, count);
            maxCount = Math.max(maxCount, count);
        }

        // count tasks with max count
        for(int count : ncount.values()){
            if(count == maxCount) nmc++;
        }

        // mathematic equation:-
        // for A A B B A A -> 4A 2B : n = 2
        // A _ _ A _ _ A _ _ A
        // all others can be filled in the space in between
        // if elements are less then space from last will be reduced

        int time1 = (maxCount-1)*(n+1) + nmc;
        int ans = Math.max(time1, tasks.length);
        return ans;
    }
}