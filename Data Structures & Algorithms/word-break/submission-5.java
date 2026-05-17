class Solution {
    HashMap<String, Integer> letters;
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length() + 1];
        letters = new HashMap<>();
        for(String word : wordDict){
            letters.put(word, word.length());
        }

        return dfs(s, wordDict,0, memo);
    }

    public boolean dfs(String s, List<String> wordDict, int index, int[] memo){
        if(memo[index] == 1){
            return false;
        }
        //0 = uncomputed, 1 = false, 2 = true;
        if(memo[index] == 2){
            return true;
        }
        if(index == s.length()){
            return true;
        }   

        boolean found = false;
        for(String word : wordDict){
            int length = word.length();
            
            //String found
            if(index + length <= s.length() && s.substring(index, index + length).equals(word)){
                found |= dfs(s, wordDict, index + length, memo);
            }
        }

        memo[index] = (found == true) ? 2 : 1;

        return (memo[index] == 2) ? true : false;
    }
}
