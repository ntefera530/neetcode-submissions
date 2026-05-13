class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        if(has_cycle(0, -1, graph, visited) == true){
            return false;
        }

        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                return false;
            }
        }


        return true;
    }

    public boolean has_cycle(int node, int parent, HashMap<Integer, ArrayList<Integer>> graph, boolean[] visited){
        if(visited[node] == true){
            return true;
        }

        visited[node] = true;

        for(int nei : graph.get(node)){
            if(nei == parent){
                continue;
            }
            if(has_cycle(nei, node, graph, visited) == true){
                return true;
            }
        }

        return false;

    }
}
