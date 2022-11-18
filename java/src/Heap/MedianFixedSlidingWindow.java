package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

/*
    480. Sliding Window Median
    My solution using Priority Queues but it is too slow for large sets and fails leetcode.
 */
public class MedianFixedSlidingWindow {
    static PriorityQueue<Long> small =new PriorityQueue<>(Collections.reverseOrder());   // maxHeap
    static PriorityQueue<Long> large = new PriorityQueue<>();  // minHeap
    public static double[] medianSlidingWindow(int[] nums, int k) {
        if (nums.length==0) return new double [0];
        double[] result = new double[nums.length - k + 1];

        int windowSize = Math.min(k,nums.length);
        for( int i=0; i+windowSize <= nums.length;i++){
            int l =i;
            while(l< i+windowSize){
                // Push to the max heap and swap with min heap if needed.
                small.add((long) nums[l]);
                organizeHeaps();
                l++;
            }
            result[i]=calculateMedian();
            small.clear();
            large.clear();
        }

        return result;
    }

    public static double calculateMedian(){
        if (small.size() > large.size()) {
            return (double) (small.peek());
        } else if (large.size() > small.size()) {
            return (double) large.peek();
        }

        // Even # of elements, return avg of two middle nums
        return (double) (small.peek() + large.peek()) / 2;
    }

    public static void organizeHeaps(){
        long val;
        if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            val = small.poll();
            large.add(val);
        }

        // Handle uneven size
        if (small.size() > large.size() + 1) {
            val = small.poll();
            large.add(val);
        }
        if (large.size() > small.size() + 1) {
            val = large.poll();
            small.add(val);
        }
    }
}
