class Solution {
    public int hammingWeight(int n) {
        int out = 0;

        while(n > 0){
            if((n & 1) == 1){
                out++;
            }
            n = n >> 1;
        }

        return out;
    }
}
