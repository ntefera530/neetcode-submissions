class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        
        int start = 0;
        int end = 1;

        while(end < prices.length){
            if(prices[start] < prices[end]){
                max = Math.max(max, prices[end] - prices[start]);
            }
            else{
                start = end;
            }

            end++;
        }

        //max = Math.max(max, prices[end - 1] - prices[start]);
        return max;
    }
}
