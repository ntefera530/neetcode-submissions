class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int max = 0;

        for(int i = 0; i < left.length; i++){
            if(i == 0){
                left[i] = 0;
            }
            else{
                left[i] = Math.max(left[i - 1], height[i - 1]);
            }
        }

        for(int i = height.length - 1; i >= 0; i--){
            if(i == height.length - 1){
                right[i] = 0;
            }
            else{
                right[i] = Math.max(right[i + 1], height[i + 1]);
            }
        }

        for(int i = 0; i < left.length; i++){      
            int sum = Math.min(right[i], left[i]) - height[i];
            if(sum > 0){
                max += sum;
            }

        }

        return max;
    }
}
