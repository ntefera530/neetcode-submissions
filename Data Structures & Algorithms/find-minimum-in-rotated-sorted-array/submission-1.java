class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        if (nums[l] <= nums[r]) return nums[l];

        while(l <= r){
            int mid = l + ((r - l) / 2);

            //both sorted
            if(nums[l] <= nums[mid] && nums[mid] <= nums[r]){
                return nums[l];
            }
            //right side is sorted, minimum is to the left (including mid)
            else if(nums[mid] < nums[r]){
                r = mid;
            }
            //left side is sorted, minimum is to the right
            else {
                l = mid + 1;
            }
        }

        return nums[l];
    }
}