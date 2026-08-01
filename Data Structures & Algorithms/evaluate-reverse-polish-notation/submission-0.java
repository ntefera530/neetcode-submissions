class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();

        int x = 0;
        int y = 0;
        
        for(String token : tokens){
            switch(token){
                case "+":
                    x = Integer.parseInt(s.pop());
                    y = Integer.parseInt(s.pop());
                    s.push(Integer.toString(x + y));
                    break;
                case "*":
                    x = Integer.parseInt(s.pop());
                    y = Integer.parseInt(s.pop());
                    s.push(Integer.toString(x * y));
                    break;
                case "-":
                    x = Integer.parseInt(s.pop());
                    y = Integer.parseInt(s.pop());
                    s.push(Integer.toString(y - x));
                    break;
                case "/":
                    x = Integer.parseInt(s.pop());
                    y = Integer.parseInt(s.pop());
                    s.push(Integer.toString(y / x));
                    break;
                default:
                    s.push(token);
                    break;
            }
        }

        return Integer.parseInt(s.peek());
    }


}
