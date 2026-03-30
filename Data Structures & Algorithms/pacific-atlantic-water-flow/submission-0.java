class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] antlantic = new boolean[heights.length][heights[0].length];
        
        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();
        
        //For pacific - Top
        for(int i=0;i<heights[0].length;i++){
            pq.offer(new int[]{0,i});
            pacific[0][i] =true;
        }
        
        //For pacific - Left
        for(int i=0;i<heights.length;i++){
            pq.offer(new int[]{i,0});
            pacific[i][0] =true;
        }

        //For Antlantic - bottom
        for(int i=0;i<heights[0].length;i++){
            aq.offer(new int[]{heights.length-1,i});
            antlantic[heights.length-1][i] =true;
        }

        //For Antlantic - right
        for(int i=0;i<heights.length;i++){
            aq.offer(new int[]{i,heights[0].length-1});
            antlantic[i][heights[0].length-1] =true;
        }

        bfs(heights,pq,pacific);
        bfs(heights,aq,antlantic);

        List<List<Integer>> sol = new ArrayList<>();

        for(int i =0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j]==true && antlantic[i][j] == true){
                    sol.add(List.of(i,j));
                }
            }
        }
        return sol;
    }

    void bfs(int[][] heights,Queue<int[]> q,boolean[][] visited){
        
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            q.poll();

            for(int i=0;i<4;i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(
                    nr>=0 && nr<heights.length
                    &&
                    nc>=0 && nc<heights[0].length
                    &&
                    !visited[nr][nc]
                    &&
                    heights[nr][nc]>=heights[row][col]
                ){
                    q.offer(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }
}
