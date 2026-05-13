class Solution {
    public int numIslands(char[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;

        boolean[][] visited = new boolean[ROW][COL];
        int count = 0;
        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    count++;
                    dfs(i, j, ROW, COL, grid, visited);
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j, int ROW, int COL, char[][] grid, boolean[][] visited){
        if(i >= ROW || i < 0 || j >= COL || j < 0 || visited[i][j] == true || grid[i][j] == '0'){
            return;
        }

        visited[i][j] = true;

        dfs(i + 1, j    , ROW, COL, grid, visited);
        dfs(i - 1, j    , ROW, COL, grid, visited);
        dfs(i    , j + 1, ROW, COL, grid, visited);
        dfs(i    , j - 1, ROW, COL, grid, visited);
    }
}
