class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = 0;

        for(int n : nums){
            //removes all potential negative starting points;
            cur = Math.max(cur, 0);

            //finds the current sum, including potential negative numbers
            cur += n;

            //finds the best sum ever found, but only allows for 1 negative number, since adding 2 negtative numbers is always woorse
            max = Math.max(max, cur);
        }


        return max;
    }
}
