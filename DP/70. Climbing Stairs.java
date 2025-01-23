class Solution {
    public int findWaysToClimb(int n , int[] dp){
        if(n == 0 || n == 1)
        return dp[n] = 1;
        else if(dp[n] != 0)
        return dp[n];
        else
        return dp[n] = findWaysToClimb(n - 1 , dp) + findWaysToClimb(n - 2 , dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return findWaysToClimb(n , dp);        
    }
}
// TC : O(N)
// SC : N [Recursive Stack Space] + N [DP Array] => O(2N)
