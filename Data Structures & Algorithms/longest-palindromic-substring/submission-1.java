class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int start = 0;
        int max_length = 0;

        int n = s.length();
        int[][] matrix = new int[n][n];

        //one letter palindromes
        for(int i = n; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(i == j){
                    matrix[i][j] = 1;
                }
            }
        }

        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if (j - i < 3 || matrix[i + 1][j - 1] == 1) {
                        matrix[i][j] = 1;
                        if(max_length < j - i + 1){
                            max_length = j - i + 1;
                            start = i; 
                        }        
                    }
                }
            }
        }

        return s.substring(start, start + max_length);

    }
}
