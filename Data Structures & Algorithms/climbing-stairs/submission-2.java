class Solution {
    public int climbStairs(int n) {
        int prev2=1;
        int prev =1;

        for(int i=2;i<=n;i++){
             int curr = prev + prev2;
             prev2 = prev;
             prev =curr;
        }
        return prev;
    }

    // int getWaysCount(int st,int[] dp){
    //     if(st==0)return 1;
    //     if(st==1)return 1;

    //     if(dp[st]!=-1)return dp[st];

    //     return dp[st] = getWaysCount(st-1,dp) + getWaysCount(st-2,dp);

    // }
}
