class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }

        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();

        for(char c : t.toCharArray()){
            tmap.putIfAbsent(c,0);
            tmap.put(c, tmap.get(c) + 1);
        }

        int minL = -1;
        int minR = -1;
        int min = Integer.MAX_VALUE;

        int start = 0;
        for(int end = 0; end < s.length(); end++){
            char endLetter = s.charAt(end);
            smap.putIfAbsent(endLetter,0);
            smap.put(endLetter, smap.get(endLetter) + 1);
            //System.out.println(s.substring(minL, minR));

            while(contains(tmap,smap)){
                if(min > end - start + 1){
                    min = end - start + 1;
                    minL = start;
                    minR = end;
                }

                char startLetter = s.charAt(start);
                smap.putIfAbsent(startLetter,0);
                smap.put(startLetter, smap.get(startLetter) - 1);
                start++;
 
            }

        }
        return (minL == -1) ? "" : s.substring(minL, minR + 1);
    }

    public boolean contains(HashMap<Character, Integer> tmap, HashMap<Character, Integer> smap){
        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            if(!smap.containsKey(key) || smap.get(key) < value){
                return false;
            }
        }

        return true;
    }
}
