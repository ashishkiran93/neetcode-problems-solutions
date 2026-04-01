class Solution {
    public void solve(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<m;i++){
            if(board[0][i]=='O'){
                q.offer(new int[]{0,i});
                visited[0][i]=true;
            }
            if(board.length>1 && board[n-1][i]=='O'){
                q.offer(new int[]{n-1,i});
                visited[n-1][i]=true;
            }
        }

        for(int i=1;i<board.length-1;i++){
            if(board[i][0]=='O'){
                q.offer(new int[]{i,0});
                visited[i][0] = true;
            }
            if(board[0].length>1 && board[i][m-1]=='O'){
                q.offer(new int[]{i,m-1});
                visited[i][m-1] = true;
            }
        }
      
    bfs(board,q,n,m,visited);

    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            if(board[i][j]=='O' && visited[i][j]==false){
                board[i][j]='X';
            }
        }
    }

 }

    void bfs(char[][] board,Queue<int[]> q,int n,int m,boolean[][] visited){
        
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            q.poll();

            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(
                    nr>=0 && nr<n
                    &&
                    nc>=0 && nc<m
                    &&
                    visited[nr][nc] == false
                    &&
                    board[nr][nc] =='O'
                ){
                    q.offer(new int[]{nr,nc});
                    visited[nr][nc]=true;
                }
            }

        }
    }
}
