class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        dfs(0 ,nums, out,  new ArrayList<>());
        return out;
    }

    public void dfs(int index, int[] nums, List<List<Integer>> out, List<Integer> cur){
        if(index == nums.length){
            out.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[index]);
        dfs(index+1, nums, out, cur);
        cur.remove(cur.size() - 1);
        dfs(index+1, nums, out, cur);
    }
}
