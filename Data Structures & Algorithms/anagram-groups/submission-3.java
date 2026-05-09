class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] unsorted = s.toCharArray();
            Arrays.sort(unsorted);
            String sorted = new String(unsorted);
        
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
            
        }

        return new ArrayList<>(map.values());
    }
}
