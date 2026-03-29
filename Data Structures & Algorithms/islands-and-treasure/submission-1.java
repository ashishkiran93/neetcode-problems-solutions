class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>(); 
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j,0});
                }
            }
        }
        bfs(grid,q);
    } 

    void bfs(int[][] grid, Queue<int[]> q ){

       while(!q.isEmpty()){
        
        int row = q.peek()[0];
        int col = q.peek()[1];
        int dist = q.peek()[2];
        q.poll();

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(
                nr>=0 && nr<grid.length
                &&
                nc>=0 && nc<grid[0].length
                &&
                grid[nr][nc] == Integer.MAX_VALUE
            ){
                grid[nr][nc] = dist+1;
                q.offer(new int[]{nr,nc,dist+1});
            }
        }

       }
    }
}
