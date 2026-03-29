class Solution {
    public int numIslands(char[][] grid) {
       boolean[][] visited = new boolean[grid.length][grid[0].length];
       int count =0;
       for(int i=0;i<grid.length;i++){
        for(int j =0;j<grid[0].length;j++){
            if(grid[i][j]=='1' && visited[i][j]==false){
                dfs(i,j,grid,visited);
                count++;
            }
        }
       }
       return count; 
    }
    
    void dfs(int row,int col,char[][] grid , boolean[][] visited ){
        visited[row][col] = true;

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
                grid[nrow][ncol]=='1'
                &&
                visited[nrow][ncol] ==false 
            )
            {
                dfs(nrow,ncol,grid,visited);
            }
        }
    }

}
