class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int prev2 = cost[0];
        int prev = cost[1];

        for(int i=2;i<=n;i++){
            int minCost = Math.min(prev,prev2);
            int curr = i==n?minCost : minCost+cost[i];
            prev2 = prev;
            prev=curr;
        }

        return prev;
    }

    int getMinCost(int ind,int[] cost,int[] dp){
        if(ind==0) return cost[0];
        if(ind==1) return cost[1];

        if(dp[ind]!=-1) return dp[ind];

        int minCost = Math.min(
            getMinCost(ind-1,cost,dp)
            ,
            getMinCost(ind-2,cost,dp)
        );

        return dp[ind] = ind==cost.length?minCost:minCost+cost[ind];
    }
}
