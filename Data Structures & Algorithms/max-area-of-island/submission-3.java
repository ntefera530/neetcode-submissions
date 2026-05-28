class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int ROW = grid.length;
        int COL = grid[0].length;

        int[][] visited = new int[ROW][COL];

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    max = Math.max(dfs(i,j,ROW,COL, grid,visited), max);
                }
            }
        }

        return max;
    }

    public int dfs(int i, int j, int ROW, int COL, int[][] grid, int[][] visited){
        if(i < 0 || i >= ROW || j < 0 || j >= COL || grid[i][j] == 0 || visited[i][j] == 1){
            return 0;
        }

        visited[i][j] = 1;

        return 1 + dfs(i + 1,j,ROW,COL, grid,visited) +
        dfs(i - 1,j,ROW,COL, grid,visited) +
        dfs(i,j + 1,ROW,COL, grid,visited) +
        dfs(i,j - 1,ROW,COL, grid,visited);

        //visited[i][j] = 0;
    }
}
