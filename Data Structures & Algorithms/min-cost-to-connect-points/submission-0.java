class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int minCost =0;
        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int cost = node[0];
            int u = node[1];

            if(vis[u])continue;
            vis[u]=true;
            minCost += cost;

            for(int v=0;v<n;v++){
                if(!vis[v]){
                  int currCost = Math.abs(points[u][0]-points[v][0])+
                                 Math.abs(points[u][1]-points[v][1]);

                  pq.offer(new int[]{currCost,v});
                }
            }
        }
        return minCost;
    }
}
