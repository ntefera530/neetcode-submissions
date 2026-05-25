class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        int start = 0;

        for(int end = 0; end < nums.length; end++){

            if(s.contains(nums[end])){
                return true;
            }            
            s.add(nums[end]);

            while(end - start + 1 > k){
                s.remove(nums[start]);
                start++;
            }


        }

        return false;
    }
}