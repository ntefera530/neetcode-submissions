class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for(int end = 0; end < nums.length; end++){
            sum += nums[end];

            while(sum >= target){
                min = Math.min(min, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }

        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}