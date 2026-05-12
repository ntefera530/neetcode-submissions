class Solution {
    public int getSum(int a, int b) {
        int out = 0;
        int carry = 0;

        for(int i = 0; i < 32; i++){
            int ar = a & 1;
            int br = b & 1;

            int sum = ar ^ br ^ carry;

            out |= (sum << i);

            a = a >> 1;
            b = b >> 1;


            if(ar + br + carry > 1){
                carry = 1;
            }
            else{
                carry = 0;
            }

        }

        return out;
    }
}
