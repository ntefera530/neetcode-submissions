class MinStack {
    Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.add(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        Stack<Integer> buffer = new Stack<>();

        while(stack.isEmpty() == false){
            int cur = stack.pop();
            min = Math.min(min, cur);

            buffer.add(cur);
        }

        while(buffer.isEmpty() == false){
            int cur = buffer.pop();
            stack.add(cur);
        }

        return min;
    }
}
