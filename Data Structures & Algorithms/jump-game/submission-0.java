class Solution {
    public boolean canJump(int[] nums) {
        boolean[] reach = new boolean[nums.length];

        return dfs(nums, 0);

    }

    public boolean dfs(int[] nums, int index){
        if(index >= nums.length){
            return false;
        }

        if(index == nums.length - 1){
            return true;
        }

        if(nums[index] == 0){
            return false;
        }

        for(int i = 1; i < nums[index] + 1; i++){
            if(dfs(nums, index + i)){
                return true;
            }
        }

        return false;
    }
}
