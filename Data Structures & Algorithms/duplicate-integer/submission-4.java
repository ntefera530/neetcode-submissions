class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dups = new HashSet<>();
        for(int n : nums){
            if(dups.contains(n) == true){
                return true;
            }
            dups.add(n);
        }

        return false;
    }
}