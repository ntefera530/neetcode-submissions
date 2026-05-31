class Solution {
    public void solve(char[][] board) {
        int ROW = board.length;
        int COL = board[0].length;

        for(int i = 0; i < ROW; i++){
            if(board[i][0] == 'O'){
                dfs(i,0, ROW, COL, board);
            }
            if(board[i][COL - 1] =='O'){
                dfs(i,COL - 1, ROW, COL, board);
            } 
        }
        for(int j = 0; j < COL; j++){
            if(board[0][j] == 'O'){
                dfs(0,j, ROW, COL, board);
            }
            if(board[ROW - 1][j] =='O'){
                dfs(ROW - 1,j, ROW, COL, board);
            }
        }

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
                else{
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int i, int j, int ROW, int COL, char[][] board){
        if(i < 0 || i >= ROW || j < 0 || j >= COL || board[i][j] == 'X' || board[i][j] == 'T'){
            return;
        }

        board[i][j] = 'T';

        dfs(i + 1,j, ROW, COL, board);
        dfs(i - 1,j, ROW, COL, board);
        dfs(i,j + 1, ROW, COL, board);
        dfs(i,j - 1, ROW, COL, board);
    }
}
