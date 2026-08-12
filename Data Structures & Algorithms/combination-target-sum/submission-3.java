class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> out = new ArrayList<>();
        dfs(0, nums, target,  out,  new ArrayList<>());
        return out;
    }

    public void dfs(int index, int[] nums, int target, List<List<Integer>> out, List<Integer> cur){
        if(target == 0){
            out.add(new ArrayList<>(cur));
            return;
        }
        if(target < 0){
            return;
        }

        for(int i = index; i < nums.length; i++){
            cur.add(nums[i]);
            dfs(i, nums, target - nums[i], out, cur);
            cur.remove(cur.size() - 1);
        }
    }        
    
}
