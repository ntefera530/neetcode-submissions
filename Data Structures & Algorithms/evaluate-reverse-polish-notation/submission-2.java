class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> intStack = new Stack<>();
        int x = 0;
        int y = 0;
        
        for(String token : tokens){
            switch(token){
                case "+":
                    x = intStack.pop();
                    y = intStack.pop();
                    intStack.push(x + y);
                    break;
                case "*":
                    x = intStack.pop();
                    y = intStack.pop();
                    intStack.push(x * y);
                    break;
                case "-":
                    x = intStack.pop();
                    y = intStack.pop();
                    intStack.push(y - x);
                    break;
                case "/":
                    x = intStack.pop();
                    y = intStack.pop();
                    intStack.push(y / x);
                    break;
                default:
                    intStack.push(Integer.parseInt(token));
                    break;
            }
        }

        return intStack.peek();
    }


}
