class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return getWaysCount(n,dp);
    }

    int getWaysCount(int st,int[] dp){
        if(st==0)return 1;
        if(st==1)return 1;

        if(dp[st]!=-1)return dp[st];

        return dp[st] = getWaysCount(st-1,dp) + getWaysCount(st-2,dp);

    }
}
