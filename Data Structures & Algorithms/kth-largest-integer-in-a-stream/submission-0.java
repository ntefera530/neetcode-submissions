class KthLargest {
    PriorityQueue<Integer> heap;
    int limit;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        limit = k;
        for(int n : nums){
            heap.offer(n);
            while(heap.size() > limit){
                heap.poll();
            }            
        }

    }
    
    public int add(int val) {
        heap.offer(val);
        while(heap.size() > limit){
            heap.poll();
        }     
        return heap.peek();
    }
}
