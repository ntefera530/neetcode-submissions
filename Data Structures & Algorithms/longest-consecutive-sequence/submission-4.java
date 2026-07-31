class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();

        int out = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int n : nums){
            s.add(n);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        for(int i = 0 ; i < nums.length; i++){
            if(s.contains(nums[i] - 1)){
                continue;
            }

            int count = 0;
            int num = nums[i];

            while(s.contains(num)){
                count++;
                num += 1;

                out = Math.max(out, count);
            }
        }

        return out;
    }
}
