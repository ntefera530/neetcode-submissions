class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : stones){
            heap.offer(n);
        }

        while(heap.size() > 1){
            int x = heap.poll();
            int y = heap.poll();

            if(x > y){
                heap.offer(x - y);
            }
            else if (x < y){
                heap.offer(y - x);
            }
        }

        if(heap.size() == 0){
            return 0;
        }

        return heap.peek();
    }
}
