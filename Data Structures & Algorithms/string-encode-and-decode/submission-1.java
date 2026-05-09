class Solution {

    public String encode(List<String> strs) {
        String line = "";
        for(String s : strs){
            String num = Integer.toString(s.length());
            line += num + "#" + s;
        }

        return line;
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();


        int start = 0;
        int delim = 0;
        while(start < str.length()){
            if(str.charAt(delim) == '#'){
                int length = Integer.parseInt(str.substring(start, delim));
                output.add(str.substring(delim + 1, delim + 1 + length));
                start = delim + 1 + length;
                delim = start;
            }

            delim++;
        }

        return output;
    }
}
