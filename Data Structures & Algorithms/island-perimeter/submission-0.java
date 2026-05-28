class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int ROW = grid.length;
        int COL = grid[0].length;

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                //Check each side;
                if(outBound(i - 1, j, ROW, COL) || grid[i - 1][j] == 0){
                    count += 1;
                }
                if(outBound(i + 1, j, ROW, COL) || grid[i + 1][j] == 0){
                    count += 1;
                }
                if(outBound(i, j + 1, ROW, COL) || grid[i][j + 1] == 0){
                    count += 1;
                }
                if(outBound(i, j - 1, ROW, COL) || grid[i][j - 1] == 0){
                    count += 1;
                }
                
            }
        }

        return count;
    }


    public boolean outBound(int i, int j, int ROW, int COL){
        if(i < 0 || i >= ROW || j < 0 || j >= COL){
            return true;
        }

        return false;
    }
}