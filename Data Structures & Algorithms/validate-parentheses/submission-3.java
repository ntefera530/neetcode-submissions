class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for(int i = 0; i < s.length(); i++){
            char bracket = s.charAt(i);
            if(bracket == ')' || bracket == '}' || bracket == ']'){
                if(stack.isEmpty() || stack.pop() != map.get(bracket)){
                    return false;
                }
            }
            else{
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}
