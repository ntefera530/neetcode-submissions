class Solution {
    public int missingNumber(int[] nums) {
        int out = 0;

        for(int i = 0; i < nums.length + 1; i++){
            out = out ^ i;
        }
        for(int n : nums){
            out = n ^ out;
        }
        
        return out;
    }
}
