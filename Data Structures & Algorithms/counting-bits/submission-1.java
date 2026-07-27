class Solution {
    public int[] countBits(int n) {
        int[] out = new int[n + 1];

        for(int i = 0; i < n + 1; i++){
            out[i] = count(i);
        }

        return out;
    }

    public int count(int n){
        int count = 0;

        while(n > 0){
            if((n & 1) == 1){
                count++;
            }

            n = n >> 1;
        }

        return count;
    }
}
