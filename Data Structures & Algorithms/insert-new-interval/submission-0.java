class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> buffer = new ArrayList<>();

        int i = 0;
        while(i < n){
            int[] cur = intervals[i];
            int start1 = cur[0];
            int end1 = cur[1];

            int start2 = newInterval[0];
            int end2 = newInterval[1];

            if(start2 > end1){
                buffer.add(cur);
            }
            else{
                break;
            }
            i++;
        }

        //start merging
        while(i < n){
            int[] cur = intervals[i];
            int start2 = cur[0];
            int end2 = cur[1];

            int start1 = newInterval[0];
            int end1 = newInterval[1];

            if(start2 <= end1){
                newInterval[0] = Math.min(start1, start2);
                newInterval[1] = Math.max(end1, end2);
            }
            else{
                break;
            }


            i++;
        }

        buffer.add(newInterval);

        //add any unmerged
        while(i < n){
            buffer.add(intervals[i]);
            i++;
        }



        return buffer.toArray(new int[buffer.size()][]);
    }
}
