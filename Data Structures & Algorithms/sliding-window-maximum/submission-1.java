class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> out = new ArrayList<>();

        int start = 0;
        int end = 0;

        int sum = 0;

        int[] max = new int[k];

        while(end < nums.length){

            while(end - start + 1 <= k){

                end++;
            }

            out.add(getMax(nums, start, end));
            start++;
        }

        int[] intArray = out.stream()
                                    .mapToInt(Integer::intValue)
                                    .toArray();
        return intArray;
    }

    public int getMax(int[] nums, int start, int end){
        int max = Integer.MIN_VALUE;

        for(int i = start; i < end; i++){
            max = Math.max(max, nums[i]);
        }

        return max;
    }
}
