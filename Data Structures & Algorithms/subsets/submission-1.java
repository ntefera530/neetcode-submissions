class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();

        dfs(nums,out, 0, new ArrayList());
        return out;
    }

    public void dfs(int[] nums, List<List<Integer>> out, int index, List<Integer> cur){
        if(index >= nums.length){
            out.add(new ArrayList<>(cur));
            return;
        }



        cur.add(nums[index]);
        dfs(nums, out, index + 1, cur);
        cur.remove(cur.size() - 1);

        dfs(nums, out, index + 1, cur);        
    }

    
}
