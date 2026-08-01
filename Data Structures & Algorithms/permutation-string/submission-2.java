class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> mapS1 = new HashMap<>();
        HashMap<Character, Integer> mapS2 = new HashMap<>();

        for(char c : s1.toCharArray()){
            mapS1.put(c, mapS1.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        for(int end = 0; end < s2.length(); end++){
            char endLetter = s2.charAt(end);
            mapS2.put(endLetter, mapS2.getOrDefault(endLetter, 0) + 1);

            while(end - start + 1 == s1.length()){
                if(sameIgnoringZeros(mapS1, mapS2)){
                    return true;
                }
                System.out.println(s2.substring(start, end + 1));
                char frontLetter = s2.charAt(start);
                mapS2.put(frontLetter, mapS2.get(frontLetter) - 1);
                start++;
            }


        }

        return false;

    }

    public static boolean sameIgnoringZeros(Map<Character, Integer> a, Map<Character, Integer> b) {
        Map<Character, Integer> filteredA = a.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<Character, Integer> filteredB = b.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return filteredA.equals(filteredB);
    }
}
