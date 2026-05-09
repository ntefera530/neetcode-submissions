class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l <= r){
            //left
            while(l <= r && !isValidChar(s.charAt(l))){
                l++;
            }
            while(l <= r && !isValidChar(s.charAt(r))){
                r--;
            }
            if(l <= r && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)) ){
                return false;

            }
            l++;
            r--;
        }

        return true;
    }

    public boolean isValidChar(char c){
        if(Character.isDigit(c) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)){
            return true;
        }
        return false;
    }
}
