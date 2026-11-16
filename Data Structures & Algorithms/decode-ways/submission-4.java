// Top down dp, with an array

class Solution {
    private int dfs(String s, int i, int[] dp) {
        if (dp[i] != -1)
            return dp[i];
        if (s.charAt(i) == '0') {
            dp[i] = 0;
            return 0;
        }

        int res = 0;
        res += dfs(s, i + 1, dp);
        if (i < s.length() - 1) {
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                res += dfs(s, i + 2, dp);
            }
        }

        dp[i] = res;
        return res;
    }
    public int numDecodings(String s) {
        // dp[i] = # of ways to decode s[i:End]
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        dp[s.length()] = 1;

        return dfs(s, 0, dp);
    }
}
