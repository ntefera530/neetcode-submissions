class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;

        List<int[]> buffer = new ArrayList<>();
        boolean last = false;
        for(int i = 1; i < n; i++){
            int[] current = intervals[i];
            int[] prev = intervals[i - 1];

            int start1 = prev[0];
            int end1 = prev[1];

            int start2 = current[0];
            int end2 = current[1];

            //merge to current index
            if(start2 <= end1){
                intervals[i][0] = Math.min(start1, start2);
                intervals[i][1] = Math.max(end1, end2);
                if(i == n - 1){
                    last = true;
                }
            }
            else{
                buffer.add(prev);
            }
        }

        buffer.add(intervals[n - 1]);

        //Convert List to 2d array

        return buffer.toArray(new int[buffer.size()][]);
    }
}
