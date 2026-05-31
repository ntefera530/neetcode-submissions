class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;

        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(grid[i][j] ==  0){
                    q.offer(new int[]{i , j});
                }
            }
        }

        int level = 0;
        while(q.isEmpty() == false){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] pair = q.poll();
                int x = pair[0];
                int y = pair[1];


                for(int j = 0; j < 4; j++){
                    int newX = x + dx[j];
                    int newY = y + dy[j];

                    if(newX >= 0 && newX < ROW && newY >= 0 && newY < COL && grid[newX][newY] == Integer.MAX_VALUE){
                        grid[newX][newY] = level + 1;
                        q.add(new int[]{newX, newY});
                    }
                }
            }

            level += 1;
        }
    }
}
