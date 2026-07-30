class Solution {

    public String encode(List<String> strs) {
        String encoded = "";

        for(String s : strs){
            int length = s.length();
            encoded += length + "#" + s;
        }

         System.out.println("Encoded: " + encoded);
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        int start = 0, end = 0;

        while(end < str.length()){

            if(str.charAt(end) == '#'){
                String length = str.substring(start, end);
                System.out.println("String length: " + length);


                int word_length = Integer.parseInt(length);
                String word = str.substring(end + 1, end + 1 + word_length);
                System.out.println("word: " + word);

                System.out.println("String : " + length);

                
                start = end + word_length + 1;
                end = end + word_length + 1;
                decoded.add(word);
            }

            end++;
        }


        return decoded;
    }
}
