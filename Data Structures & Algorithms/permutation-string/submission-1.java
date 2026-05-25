class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count1 = new int[256];
        int[] count2 = new int[256];

        for(char c : s1.toCharArray()){
            count1[c]++;
        }

        int window = s1.length();
        int start = 0;

        for(int end = 0; end < s2.length(); end++){

            count2[s2.charAt(end)]++;

            while(end - start + 1 > window){
                count2[s2.charAt(start)]--;
                start++;
            }

            if(same(count1, count2)){
                return true;
            }
        }

        return false;
    }

    public boolean same(int[] a, int[] b){
        for(int i = 0; i < 256; i++){
            if(a[i] != b[i]){
                return false;
            }
        }

        return true;
    }
}
