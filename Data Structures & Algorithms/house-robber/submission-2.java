class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return dfs(nums, 0, memo);
    }

    public int dfs(int[] nums, int index, int[] memo){
        if(index >= nums.length){
            return 0;
        }

        if(memo[index] != -1){
            return memo[index];
        }

        memo[index] = Math.max( dfs(nums, index + 1, memo) , nums[index] + dfs(nums, index + 2, memo) );
        
        return memo[index];

    }
}
