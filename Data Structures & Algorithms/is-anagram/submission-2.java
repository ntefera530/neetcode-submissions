class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> countT = new HashMap<>();
        HashMap<Character, Integer> countS = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            countT.put( t.charAt(i) , countT.getOrDefault(t.charAt(i), 0) + 1);
            countS.put( s.charAt(i) , countS.getOrDefault(s.charAt(i), 0) + 1);
        }

        return countT.equals(countS);
    }
}
