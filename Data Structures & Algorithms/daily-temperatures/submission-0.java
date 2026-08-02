class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] out = new int[n];
        stack.push(-1);

        for(int i  = n - 1; i >= 0; i--){
            out[i] = closest(temperatures[i] ,stack);
            stack.push(temperatures[i]);
        }

        return out;
    }

    public int closest(int num, Stack<Integer> stack){
        Stack<Integer> copy = new Stack<>();
        copy.addAll(stack); // preserves order
        
        System.out.println(stack);
        int count = 0;
        while(copy.peek() != -1){
            count++;            
            if(num < copy.peek()){
                return count;
            }  
            copy.pop();

        }

        return 0;
    }
    
}
