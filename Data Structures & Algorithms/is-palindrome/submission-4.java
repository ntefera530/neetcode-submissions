class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l < r){


            while(l < r && !isValid(l , s)){
                l++;
            }
            while(l < r && !isValid(r, s)){
                r--;
            }

            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    public boolean isValid(int index, String s){
        char c = s.charAt(index);

        return (c >= 'A' && c <= 'Z' ||
        c >= 'a' && c <= 'z' ||
        c >= '0' && c <= '9');
    }

}
