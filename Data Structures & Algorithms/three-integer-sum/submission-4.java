class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // i + j + k = 0;
        // i + j = -k

        List<List<Integer>> output = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            //skip duplicates
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while(j < k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[j]);
                    cur.add(nums[k]);
                    output.add(new ArrayList<>(cur));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                }
                else if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }
                else{
                    j++;
                }
            }
        }

        return output;
    }
}
