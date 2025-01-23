class Solution {
    public int findFib(int n , int[] dp)
    {
        if(n <= 1)
        return dp[n] = n;
        else if(dp[n] != 0)
        return dp[n];
        else
        return dp[n] = findFib(n - 1 , dp) + findFib(n - 2 , dp);
    }
    public int fib(int n) {
        int[] dp = new int[n + 1];
        findFib(n , dp);
        return dp[n];
        
    }
}
// TC : O(N)
// SC : N[Recursive Stack Space] + N[DP Array] => O(2N)
