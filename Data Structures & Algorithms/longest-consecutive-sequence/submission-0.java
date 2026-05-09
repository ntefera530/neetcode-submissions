class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int n: nums){
            set.add(n);
        }

        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i] - 1)){
                int count = 0;
                int x = nums[i];
                while(set.contains(x)){
                    count++;
                    x += 1;
                }
                max = Math.max(max,count);
            }
        }

        return max;
    }
}
