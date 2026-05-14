class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int n = intervals.length;
        int count = 0;

        for(int i = 1; i < n; i++){
            int[] cur = intervals[i];
            int[] prev = intervals[i-1];

            int start1 = prev[0];
            int end1 = prev[1];

            int start2 = cur[0];
            int end2 = cur[1];

            if(start2 < end1){
                count++;
                intervals[i] = (end1 > end2) ? cur : prev;
            }

        }

        return count;
    }
}
