class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
        }

        int[] indegree = new int[numCourses];

        for(int i=0;i<adj.size();i++){
            for(int curr : adj.get(i)){
                indegree[curr]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)q.offer(i);
        }

        int[] topo = new int[numCourses];
        int i=0;
        int count =0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo[i++] = node;
            count++;
            for(int curr : adj.get(node)){
                indegree[curr]--;
                if(indegree[curr]==0)q.add(curr);
            }
        }
        
        return (count==numCourses)?topo:new int[0];
    }
}
