class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROW = heights.length;
        int COL = heights[0].length;

        boolean[][] pac = new boolean[ROW][COL];
        boolean[][] atl = new boolean[ROW][COL];

        List<List<Integer>> out = new ArrayList<>();

        //dfs from pac if (row = 0 or col = 0)
        //dfs from atl if (row = length - 1 or col = length - 1)

        for(int j = 0; j < COL; j++){
            dfs(0      , j, ROW, COL, Integer.MIN_VALUE, heights, pac);
            dfs(ROW - 1, j, ROW, COL, Integer.MIN_VALUE, heights, atl);
        }

        for(int i = 0; i < ROW; i++){
            dfs(i, 0      , ROW, COL, Integer.MIN_VALUE, heights, pac);
            dfs(i, COL - 1, ROW, COL, Integer.MIN_VALUE, heights, atl);
        }

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(atl[i][j] == true && pac[i][j] == true){
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    out.add(new ArrayList<>(pair));
                }
            }
        }

        return out;
    }

    public void dfs(int i, int j, int ROW, int COL, int parent, int[][] heights, boolean[][] visited){
        if(i >= ROW || i < 0 || j >= COL || j < 0 || heights[i][j] < parent || visited[i][j] == true){
            return;
        }

        visited[i][j] = true;

        dfs(i + 1, j    , ROW, COL, heights[i][j], heights, visited);
        dfs(i - 1, j    , ROW, COL, heights[i][j], heights, visited);
        dfs(i    , j + 1, ROW, COL, heights[i][j], heights, visited);
        dfs(i    , j - 1, ROW, COL, heights[i][j], heights, visited);
        
    }
}
