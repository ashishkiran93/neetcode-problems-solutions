class Solution {
    public int countComponents(int n, int[][] edges) {
      List<List<Integer>> adj  =new ArrayList<>();
      boolean[] visited = new boolean[n];
      for(int i=0;i<n;i++)adj.add(new ArrayList<>());

      for(int i=0;i<edges.length;i++){
        int u = edges[i][0];
        int v = edges[i][1];

        adj.get(u).add(v);
        adj.get(v).add(u);
      }
      int count =0;
      for(int i=0;i<n;i++){
        if(visited[i]==false){
            count++;
            dfs(i,visited,adj);
        }
      }
      return count;
    }

    void dfs(int num,boolean[] visited,List<List<Integer>> adj){
        visited[num]=true;
        
         for(int curr:adj.get(num)){
                if(visited[curr]==false){
                    dfs(curr,visited,adj);
                }
        }
        
    }
}
