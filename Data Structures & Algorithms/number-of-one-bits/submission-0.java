class Solution {
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((n & mask) == 1){
                count++;
            }
            n = n >> 1;
        }

        return count;
        
    }
}
