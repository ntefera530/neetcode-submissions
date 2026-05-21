class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                count++;
                dfs(graph, visited, i);
            }   
        }

        return count;
    }

    public void dfs(HashMap<Integer, List<Integer>> graph, boolean[] visited, int node){
        if(visited[node] == true){
            return;
        }

        visited[node] = true;
        graph.putIfAbsent(node, new ArrayList<>());

        for(int nei : graph.get(node)){
            if(visited[nei] == false){
                dfs(graph, visited, nei);
            }        
        }
    }
}
