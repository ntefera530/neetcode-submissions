class Solution {
    public int maxProfit(int[] prices) {
        
        int max = 0;

        int start = 0;

        for(int end = 0; end < prices.length; end++){
            max = Math.max(max, prices[end] - prices[start]);
            if(prices[start] > prices[end]){
                start = end;
                //end = start;
            }

            
        }

        return max;
    }
}
