class Solution {
    public int orangesRotting(int[][] grid) {
        int count = 0;

        int ROW = grid.length;
        int COL = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(grid[i][j] == 1){
                    count++;
                }
                if(grid[i][j] == 2){
                   q.offer(new int[]{i, j}); 
                }
            }
        }

        int level = 0;
        while(count > 0 && q.isEmpty() == false){
            int size = q.size();

           for(int i = 0; i < size; i++){
                int[] pair = q.poll();
                int x = pair[0];
                int y = pair[1];

                for(int j = 0; j < 4; j++){
                    int newX = x + dx[j];
                    int newY = y + dy[j];

                    if(newX >= 0 && newX < ROW && newY >= 0 && newY < COL && grid[newX][newY] == 1){
                        grid[newX][newY] = 2;
                        q.add(new int[]{newX, newY});
                        count -= 1;
                    }
                }
            }


            level += 1;
            
            
        }
        return (count == 0) ? level : -1;
    }
}
