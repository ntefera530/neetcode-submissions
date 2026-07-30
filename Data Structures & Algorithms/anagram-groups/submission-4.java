class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> output = new ArrayList<>();

        for(String word : strs){

            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            // if(!map.containsKey(key)){
            //     map.get(key),add(word);
            // }
            // else{
            //     map.put(key, new ArrayList<>());
            //     map.get
            // }

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            output.add(entry.getValue());
        }
        
        return output;
    }
}
