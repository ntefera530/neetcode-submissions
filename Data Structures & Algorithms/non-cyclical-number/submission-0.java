class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        

        while(!s.contains(n)){
            s.add(n);
            int sum = 0;

            //get digit sum
            while(n > 0){
                int digit = n % 10;
                System.out.print(digit + " ");
                digit = digit * digit;
                sum = sum + digit;
                n = n / 10;
                
            }
            System.out.println(" = " + sum);
            n = sum;
        }

        return (n == 1) ? true : false;
    }
}
