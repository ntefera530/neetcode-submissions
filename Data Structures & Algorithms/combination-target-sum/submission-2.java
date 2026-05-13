class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();

        dfs(nums, target, output, new ArrayList<>(), 0);

        return output;
    }

    public void dfs(int[] nums, int target, List<List<Integer>> output, List<Integer> cur, int index){
        if(target < 0){
            return;
        }
        if(target == 0){
            output.add(new ArrayList<>(cur));
            return;
        }

        for(int i = index; i < nums.length; i++){
            cur.add(nums[i]);
            dfs(nums, target - nums[i], output, cur, i);
            cur.remove(cur.size() - 1);
        }

        return;
    }
}
