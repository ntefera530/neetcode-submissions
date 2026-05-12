class Solution {
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix.length - 1;
        int top = 0;
        int bottom = matrix[0].length - 1;

        int ROW = matrix.length;
        int COL = matrix[0].length;

        //verticle Slice
        for(int i = 0; i < ROW / 2; i++){
            for(int j = 0; j < COL; j++){
                int buffer = matrix[i][j];
                matrix[i][j] = matrix[ROW - 1- i][j];
                matrix[ROW - 1- i][j] = buffer;
            }
        }

        //Transpose
        for(int i = 0; i < ROW; i++){
            for(int j = i + 1; j < COL; j++){
                int buffer = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = buffer;
            }
        }
                                                                                                                                                                                                         
    }
}
