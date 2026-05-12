class Solution {
    public void setZeroes(int[][] matrix) {
        int ROW = matrix.length;
        int COL = matrix[0].length;

        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(matrix[i][j] == 0){
                    row.put(i, 0);
                    col.put(j, 0);
                }
            }
        }

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(row.containsKey(i) || col.containsKey(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
