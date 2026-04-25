class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DS ds = new DS(n);
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(ds.findPar(u)==ds.findPar(v)){
                return new int[]{u,v};
            }
            ds.unionByRank(u,v);
        }
        return new int[2];
    }
}

class DS{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DS(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
    }

    int findPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }

    void unionByRank(int u,int v){
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);
        if(ulp_u == ulp_v)return;
        if(rank.get(ulp_u)>rank.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
        }
        else if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }
        else{
            parent.set(ulp_v,ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }
}
