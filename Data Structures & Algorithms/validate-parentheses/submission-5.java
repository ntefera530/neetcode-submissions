class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '(' || cur == '{' || cur == '['){
                st.push(cur);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                else{
                    if(cur == ')' && st.pop() != '('){
                        return false;
                    }
                    else if(cur == '}' && st.pop() != '{'){
                        return false;
                    }
                    else if(cur == ']' && st.pop() != '['){
                        return false;
                    }
                }
            }
        }


        return st.isEmpty();
    }
}
