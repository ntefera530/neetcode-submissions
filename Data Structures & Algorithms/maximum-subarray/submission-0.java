class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){

            for(int j = i; j < nums.length; j++){
                int current = 0;
                int p = i;
                while(p <= j){
                    current += nums[p];
                    p++;
                }
                max = Math.max(max, current);
            }
            
        }

        return max;
    }
}
