// link: https://leetcode.com/problems/kth-largest-element-in-an-array/

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        // // insert all in a min heap
        // for(int num : nums) {
        //     pq.add(num);
        // }
        // int ans= -1;

        // // take out K emelents to reach to the Kth min
        // for(int i=0; i<k; i++){
        //     ans = pq.poll();
        // }

        // return ans;

        //this is having a higher time complexity

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // need to have a min heap of size k
        // so that heap will have kth element on the top with k-1 other elements 
        // larger than the top element.
        
        // [2, 4, 6, 7, 8, 12, 14, 16]
        // 4th largest will be 8
        // 4 size heap should contain -> 8, 12, 14, 16

        for(int i=0; i<k; i++){
            pq.offer(nums[i]);
        }   

        // now proceed with the rest of the array
        // if array has an element greater that heap top, remove heap element and insert this one
        // because it should be part of those k-1 elements, now top will have smallest element of the heap
        // again do this for all remaining element

        for(int i=k; i<nums.length; i++){
            if(nums[i] > pq.peek()){
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }
}