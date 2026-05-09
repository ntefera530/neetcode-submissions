class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        setUp(countMap);
        int max = 0;

        int start = 0;
        for(int end = 0; end < s.length(); end++){
            char cur = s.charAt(end);
            countMap.put(cur, countMap.get(cur) + 1);
            while((end - start + 1) - getMaxInWindow(countMap) > k){
                char letter = s.charAt(start);
                countMap.put(letter, countMap.get(letter) - 1);
                start++;
            }

            max = Math.max(max, (end-start + 1));
        }

        return max;
    }

    public int getMaxInWindow(HashMap<Character, Integer> countMap){
        int max = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            max = Math.max(max, entry.getValue());
        }

        return max;
    }
    public void setUp(HashMap<Character, Integer> countMap){
        countMap.put('A', 0);
        countMap.put('B', 0);
        countMap.put('C', 0);
        countMap.put('D', 0);
        countMap.put('E', 0);
        countMap.put('F', 0);
        countMap.put('G', 0);
        countMap.put('H', 0);
        countMap.put('I', 0);
        countMap.put('J', 0);
        countMap.put('K', 0);
        countMap.put('L', 0);
        countMap.put('M', 0);
        countMap.put('N', 0);
        countMap.put('O', 0);
        countMap.put('P', 0);
        countMap.put('Q', 0);
        countMap.put('R', 0);
        countMap.put('S', 0);
        countMap.put('T', 0);
        countMap.put('U', 0);
        countMap.put('V', 0);
        countMap.put('W', 0);
        countMap.put('X', 0);
        countMap.put('Y', 0);
        countMap.put('Z', 0);
    }
}
