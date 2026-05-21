class Solution {
    boolean[] picked; 
    public List<List<Integer>> permute(int[] nums) {
        picked = new boolean[nums.length];
        List<List<Integer>> out = new ArrayList<>();
        dfs(nums, out, new ArrayList<>(), 0);
        return out;
    }

    public void dfs(int[] nums, List<List<Integer>> out, List<Integer> cur, int index){
        if(cur.size() ==  nums.length){
            out.add(new ArrayList<>(cur));
            return;
        }

        
        for(int i = 0; i < nums.length; i++){
            if(picked[i] == false){
                picked[i] = true;
                cur.add(nums[i]);
                dfs(nums, out, cur, index);
                cur.remove(cur.size() - 1);
                picked[i] = false;
            }
            
        }
    }

}
