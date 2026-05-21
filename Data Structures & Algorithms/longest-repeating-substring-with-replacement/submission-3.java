class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[256];

        int start = 0;
        int end = 0;

        int max = 0;
        
        while(end < s.length()){
            count[s.charAt(end)]++;
            int window = end - start + 1;
            
            while(window - getMax(count) > k){
                count[s.charAt(start)]--;
                start++;
                window = end - start + 1;
            }

            max = Math.max(max, window);
            end++;
        }

        return max;
    }

    public int getMax(int[] counts){
        int max = 0;
        for(int x : counts){
            max = Math.max(max, x);
        }

        return max;
    }
}