class Solution {
    HashMap<Integer, Integer> letters;
    public int numDecodings(String s) {
        letters = new HashMap<>();
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);

        for(int i = 1; i < 27; i++){
            letters.put(i, 1);
        }

        return dfs(s,0,memo);
    }

    public int dfs(String s, int index, int[] memo){

        if(memo[index] != -1){
            return memo[index];
        }    

        if(index == s.length()){
            return 1;
        }

        if(index > s.length()){
            return 0;
        }

        if(s.charAt(index) == '0'){
            return 0;
        }


        int one_digit = Integer.parseInt(String.valueOf(s.charAt(index)));
        int left = 0;
        if(letters.get(one_digit) != null &&letters.get(one_digit) == 1){
            left += dfs(s,index + 1, memo);
        }

        int right = 0;
        if (index + 1 < s.length()) {
            int two_digit = Integer.parseInt(s.substring(index, index + 2));
            if(letters.get(two_digit) != null && letters.get(two_digit) == 1){
                right += dfs(s, index + 2, memo);
            }
        }

        memo[index] = left + right;

        return memo[index];
    }
}
