class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        //Banans = 62
        //Hours = 4


        long banana_count = 0;
        long max_pile = 0;

        for(int i = 0; i < n; i++){
            max_pile = Math.max(max_pile,piles[i]);
            banana_count += piles[i];
        }

    
        long left = Math.ceilDiv(banana_count, h);
        long right = max_pile;

        long min = max_pile;
        while(left <= right){
            long mid = left + ((right - left) / 2);
            if(eat(mid,piles) <= h){
                min = Math.min(min, mid);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }

        }

        return (int)min;
    }

    public int eat(long rate, int[] piles){
        int count = 0;
        for(long p : piles){
            count += Math.ceilDiv(p, rate);
        }

        return count;
    }
}
