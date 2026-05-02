class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i=2;i<=n;i++){
            int minCost = Math.min(dp[i-1],dp[i-2]);
            dp[i] = i==n?minCost : minCost+cost[i];
        }

        return dp[n];
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
