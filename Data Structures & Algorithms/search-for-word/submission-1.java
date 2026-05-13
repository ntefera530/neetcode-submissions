class Solution {
    boolean found = false;
    public boolean exist(char[][] board, String word) {
        int ROW = board.length;
        int COL = board[0].length;

        boolean[][] visited = new boolean[ROW][COL];

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(board[i][j] == word.charAt(0)){
                    dfs(i,j, board, visited, word, ROW, COL, 0);
                }
            }
        }

        return found;
    }

    public void dfs(int i, int j, char[][] board, boolean[][] visited , String word, int ROW, int COL, int index){

        if(i >= ROW || i < 0 || 
            j >= COL || j < 0 || 
            visited[i][j] == true || 
            index >= word.length() || 
            word.charAt(index) != board[i][j]){

            return;
        }

        if(index == word.length() - 1 && word.charAt(index) == board[i][j]){
            found = true;
            return;
        }

        visited[i][j] = true;

        dfs(i + 1, j   , board, visited, word, ROW, COL, index + 1);
        dfs(i - 1, j   , board, visited, word, ROW, COL, index + 1);
        dfs(i    ,j + 1, board, visited, word, ROW, COL, index + 1);
        dfs(i    ,j - 1, board, visited, word, ROW, COL, index + 1);

        visited[i][j] = false;



    }
}
