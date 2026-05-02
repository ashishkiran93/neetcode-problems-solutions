class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
             dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    // int getWaysCount(int st,int[] dp){
    //     if(st==0)return 1;
    //     if(st==1)return 1;

    //     if(dp[st]!=-1)return dp[st];

    //     return dp[st] = getWaysCount(st-1,dp) + getWaysCount(st-2,dp);

    // }
}
