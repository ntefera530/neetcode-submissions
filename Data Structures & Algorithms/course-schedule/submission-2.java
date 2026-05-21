class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] pre : prerequisites){
            //1 --> 0
            graph.putIfAbsent(pre[1], new ArrayList<>());
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(q.isEmpty() == false){
            int node = q.poll();
            graph.putIfAbsent(node, new ArrayList<>());
            for(int nei: graph.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.add(nei);
                }
            }
        }

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] > 0){
                return false;
            }
        }

        return true;
    }
}
