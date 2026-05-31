class Solution {
    HashMap<Character, Character> prevSpin;
    HashMap<Character, Character> nextSpin;
    public int openLock(String[] deadends, String target) {
        prevSpin = new HashMap<>();
        nextSpin = new HashMap<>();
        

        setup();

        Set<String> seen = new HashSet<>();
        Set<String> dead = new HashSet<>();

        for(String s : deadends){
            if(s.equals("0000")){
                return -1;
            }
            seen.add(s);
        }

        Queue<String> q = new LinkedList<>();

        q.add("0000");
        seen.add("0000");

        int level = 0;

        while(q.isEmpty() == false){
            int size = q.size();

            for(int i = 0; i < size; i++){
                String cur = q.poll();
                if(target.equals(cur)){
                    return level;
                }

                for(int j = 0; j < 4; j++){
                    char curChar = cur.charAt(j);

                    char up_char = nextSpin.get(curChar);
                    StringBuilder sbUp = new StringBuilder(cur);
                    sbUp.setCharAt(j, up_char);
                    String newUp = sbUp.toString();
                    if(seen.contains(newUp) == false &&  dead.contains(newUp) == false){
                        seen.add(newUp);
                        q.add(newUp);
                    }

                    char down_char = prevSpin.get(curChar);
                    StringBuilder sbDown = new StringBuilder(cur);
                    sbDown.setCharAt(j, down_char);
                    String newDown = sbDown.toString();
                    if(seen.contains(newDown) == false &&  dead.contains(newDown) == false){
                        seen.add(newDown);
                        q.add(newDown);
                    }
                }
            }

            level++;
        }
        return -1;
    }

    public void setup(){
        prevSpin.put('0','9');
        prevSpin.put('1','0');
        prevSpin.put('2','1');
        prevSpin.put('3','2');
        prevSpin.put('4','3');
        prevSpin.put('5','4');
        prevSpin.put('6','5');
        prevSpin.put('7','6');
        prevSpin.put('8','7');
        prevSpin.put('9','8');

        nextSpin.put('0','1');
        nextSpin.put('1','2');
        nextSpin.put('2','3');
        nextSpin.put('3','4');
        nextSpin.put('4','5');
        nextSpin.put('5','6');
        nextSpin.put('6','7');
        nextSpin.put('7','8');
        nextSpin.put('8','9');
        nextSpin.put('9','0');
    }
}