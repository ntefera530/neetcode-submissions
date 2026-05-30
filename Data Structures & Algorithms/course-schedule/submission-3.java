class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] pre : prerequisites){
            //1 --> 0
            graph.putIfAbsent(pre[1], new ArrayList<>());
            graph.get(pre[1]).add(pre[0]);
        }

        int[] visiting = new int[numCourses + 1];
        for(int i = 0; i < numCourses; i++){
            if(dfs(i, visiting, graph)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int node, int[] visiting, HashMap<Integer, List<Integer>> graph){
        //0 = not visited
        //1 = visiting (curent Path)
        //2 = dont visiting

        if(visiting[node] == 1){
            return true;
        }

        visiting[node] = 1;
        for(int nei: graph.getOrDefault(node, new ArrayList<>())){
            if(dfs(nei, visiting, graph)){
                return true;
            }
        }
        visiting[node] = 2;
        return false;   

    }
}
