class Solution {
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1,- 1};

    public int shortestPath(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;

        int[][] visited = new int[ROW][COL];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = 1;

        int level = 0;
        while(q.isEmpty() == false){
            int size = q.size();
            

            for(int i = 0; i < size; i++){
                int[] cur = q.poll();

                //TODO - if you are at end
                int x = cur[0];
                int y = cur[1];

                //visited[x][y] = 1;

                if(x == ROW - 1 && y == COL - 1){
                    return level;
                }

                for(int j = 0; j < 4; j++){
                    int newX = x + dx[j];
                    int newY = y + dy[j];

                    if(newX >= 0 && newX < ROW && newY >= 0 && newY < COL && grid[newX][newY] != 1 && visited[newX][newY] != 1){
                        
                        q.offer(new int[]{newX, newY});
                        visited[newX][newY] = 1;
                    }
                }


            }
            level++;
        }


        return -1;
    }
}
