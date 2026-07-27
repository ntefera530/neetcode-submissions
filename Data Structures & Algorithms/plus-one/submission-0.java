class Solution {
    public int[] plusOne(int[] digits) {
        boolean carry = true;

        for(int i = digits.length - 1; i >= 0; i--){
            if(carry == true){
                digits[i] = digits[i] + 1;
                carry = false;

                if(digits[i] == 10){
                    digits[i] = 0;
                    carry = true;
                }
            }
        }

        if(carry == true){
            int[] extend = new int[digits.length + 1];
            extend[0] = 1;
            for(int i = 0; i < digits.length; i++){
                extend[i + 1] = digits[i];
            }

            return extend;
        }

        return digits;
    }
}
