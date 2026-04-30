class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       List<List<List<Integer>>> adj = new ArrayList<>();
       for(int i=0;i<n;i++)adj.add(new ArrayList<>());
       for(int[] flight : flights){
         int u = flight[0];
         int v = flight[1];
         int cost = flight[2];
         adj.get(u).add(List.of(v,cost));
       } 
 
       int[] dist = new int[n];
       Arrays.fill(dist,(int)1e9);
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

       //initialisation
       dist[src]=0;
       pq.add(new int[]{0,src,0});

       while(!pq.isEmpty()){
         int[] curr = pq.poll();
         int cost = curr[2];
         int node = curr[1];
         int stop = curr[0];

        if(stop>k)continue;

         for(List<Integer> currNode : adj.get(node) ){
            int currNodeVal = currNode.get(0);
            int currNodeCost = currNode.get(1);

            if(cost+currNodeCost<dist[currNodeVal]){
                dist[currNodeVal] = cost+currNodeCost;
                pq.offer(new int[]{stop+1,currNodeVal,dist[currNodeVal]});
            }

         }
       }



      return dist[dst]==(int)1e9?-1:dist[dst];

    }
}
