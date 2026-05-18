class Solution {
    public int countPaths(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int[][] visited = new int[ROW][COL];

        return dfs(grid, visited, 0,0, ROW, COL);
    }

    public int dfs(int[][] grid, int[][] visited, int i, int j, int ROW, int COL){
        if(i < 0 || i >= ROW || j < 0 || j >= COL || grid[i][j] == 1 || visited[i][j] == 1){
            return 0;
        }

        if(i == ROW - 1 && j == COL - 1){
            return 1;
        }

        visited[i][j] = 1;
        int result = dfs(grid, visited, i + 1, j, ROW, COL) +
                        dfs(grid, visited, i - 1, j, ROW, COL) +
                        dfs(grid, visited, i, j + 1, ROW, COL) +
                        dfs(grid, visited, i, j - 1, ROW, COL);

        visited[i][j] = 0;

        return result;
    }
}
