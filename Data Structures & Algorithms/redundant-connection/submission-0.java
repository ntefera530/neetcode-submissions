class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        int n = edges.length;
        for (int i = 0; i <= n; i++) {
            graph.putIfAbsent(i,new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

            boolean[] visited = new boolean[n + 1];
            if(dfs_cycle( edge[0], -1, graph, visited)){
                return edge;
            }
        }

        return new int[0];
    }

    public boolean dfs_cycle(int node, int parent, HashMap<Integer, List<Integer>> graph, boolean[] visited){
        if(visited[node] == true){
            return true;
        }


        visited[node] = true;

        for(int nei : graph.get(node)){
            if(nei == parent){
                continue;
            }
            if (dfs_cycle(nei, node, graph, visited)) {
                return true;
            }

        }

        return false;
    }
}
