class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            //If i is posative, all numbers are posative do no sum can be 0
            if(nums[i] > 0){
                break;  
            }
            // dont check dupllicates (ignore check on first index)
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            //System.out.println("i: " + i + ", j: " + j + ", k: " + k);
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[j]);
                    cur.add(nums[k]);

                    out.add(new ArrayList<>(cur));
                    
                    k--;
                    j++;

                    while(j < k && nums[j] == nums[j - 1]){
                        j++;
                    }
                }
                else if(sum > 0){
                    k--;
                }
                else if(sum < 0){
                    j++;
                }
              

            }

            
        }

        return out;
    }
}
