class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> sm = new HashMap<>();
        HashMap<Character, Integer> tm = new HashMap<>();

        for(char c : s.toCharArray() ){
            sm.put(c,sm.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()){
            tm.put(c,tm.getOrDefault(c, 0) + 1);
        }

        return sm.equals(tm);
    }
}
