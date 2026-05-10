class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int m = l + ((r - l)/2);

            if(nums[m] == target){
                return m;
            }

            //left sorted
            else if (nums[l] <= nums[m]){
                //in the left sorted section
                if(target >= nums[l] && target < nums[m]){
                    r = m - 1;
                }
                //in the other section
                else{
                    l = m + 1;
                }
            }
            //right sorted
            else {
                //in the right sorted section
                if(target > nums[m] && target <= nums[r]){
                    l = m + 1;
                }
                //other section
                else{
                    r = m - 1;
                }
            }
        }

        return -1;
    }
}