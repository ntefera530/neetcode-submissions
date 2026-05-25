class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int max = 0;
        int[] count = new int[256];

        for(int end = 0; end < s.length(); end ++){

            
            count[s.charAt(end)]++;   

            while((end - start + 1) - getMax(count) > k){
                count[s.charAt(start)]--;
                start++;
            }
            
            
         
max = Math.max(max, end - start + 1);


        }

        return max;
    }

    public int getMax(int[] count){
        int max = 0;

        for(int i = 0; i < count.length; i++){
            max = Math.max(max, count[i]);
        }

        return max;
    }
}
