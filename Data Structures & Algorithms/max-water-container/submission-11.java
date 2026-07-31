class Solution {
    public int maxArea(int[] heights) {
        int max = 0;

        int l = 0, r = heights.length -1;

        while(l < r){
            int base = r - l;
            int height = Math.min(heights[l], heights[r]); //cna only fill up to the smallest wall

            max = Math.max(max, base * height);

            if(height == heights[l]){
                l++;
            }
            else{
                r--;
            }
        }

        return max;
    }
}
