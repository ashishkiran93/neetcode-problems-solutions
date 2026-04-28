class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());

        for(int[] nodeTime: times){
            int u = nodeTime[0];
            int v = nodeTime[1];
            int t = nodeTime[2];
            adj.get(u).add(new Pair(v,t));
        }

        int[] dist = new int[n+1];
        for(int i=0;i<dist.length;i++)dist[i]=(int)(1e9);
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2) -> p1.dis - p2.dis);
        dist[k]=0;
        pq.offer(new Pair(k,0));
        
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int dis = pq.peek().dis;
            pq.poll();

            for(Pair currNode : adj.get(node)){
                if(currNode.dis+dis<dist[currNode.node]){
                    dist[currNode.node] = currNode.dis+dis;
                    pq.offer(new Pair(currNode.node,currNode.dis+dis));
                }
            }

        }
        int maxTime = Integer.MIN_VALUE;
        for(int i=1;i<dist.length;i++){
            int val = dist[i];
            if(val==(int)1e9)return -1;
           maxTime = Math.max(maxTime,val);
        }
        return maxTime;
    }
}

class Pair{
    int node;
    int dis;
    Pair(int node,int dis){
        this.node = node;
        this.dis=dis;
    }
}
