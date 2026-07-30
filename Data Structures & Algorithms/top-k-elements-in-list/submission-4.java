class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        HashMap<Integer, Integer> countMap = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        //count numbers
        for(int n : nums){
            countMap.putIfAbsent(n, 0);
            countMap.put(n, countMap.get(n) + 1);
        }

        //maxHeap by Number count
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            maxHeap.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        //get top K values
        while(!maxHeap.isEmpty() && k > 0){
            int[] max = maxHeap.poll();

            if(!set.contains(max[0])){
                k--;
                list.add(max[0]);
                set.add(max[0]);
            }
        }

        //convert list to int[]
        return list.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}
