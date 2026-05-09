class Solution {
    public int maxArea(int[] heights) {
        //Min wall heigh * distance
        int l = 0;
        int r = heights.length - 1;
        int max = 0;
        while(l < r){
            int min_wall = Math.min(heights[l] , heights[r]);
            int base = r - l;
            max = Math.max(min_wall * base, max);

            if(heights[l] <= heights[r]){
                l++;
            }
            else{
                r--;
            }
        }

        return max;
    }
}
