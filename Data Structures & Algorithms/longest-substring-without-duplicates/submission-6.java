class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int cur = 0;
        int start = 0;

        for(int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);

            while(set.contains(letter)){
                set.remove(s.charAt(start));
                cur--;
                start++;
            }

            set.add(letter);
            cur++;
            max = Math.max(max, cur);
            
        }

        return max;
    }
}
