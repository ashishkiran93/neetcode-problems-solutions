class Solution {
    public int maxAreaOfIsland(int[][] grid) {
       boolean[][] visited = new boolean[grid.length][grid[0].length];
       int[] maxArea = new int[1];
       for(int i=0;i<grid.length;i++){
        for(int j =0;j<grid[0].length;j++){
            if(grid[i][j]==1 && visited[i][j]==false){
              int area =  dfs(i,j,grid,visited,maxArea);
              maxArea[0] = Math.max(maxArea[0],area);
            }
        }
       }
       return maxArea[0];
    }

    int dfs(int row,int col,int[][] grid , boolean[][] visited,int[] maxArea ){
        visited[row][col] = true;
        
        int area =1;

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(
                nrow>=0 && nrow<grid.length
                &&
                ncol>=0 && ncol<grid[0].length
                &&
                grid[nrow][ncol]==1
                &&
                visited[nrow][ncol] ==false 
            )
            {
               area += dfs(nrow,ncol,grid,visited,maxArea);
            }
        }
        return area;
    }
}
