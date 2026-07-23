class Solution {
    Boolean[][] dp;
    boolean solve(String s, String p, int i, int j){
        if(i>=s.length() && j>=p.length())
            return true;

        if(j>=p.length())
            return false;

        if(i<=s.length() && dp[i][j]!=null)
            return dp[i][j];

        boolean match = i<s.length() && ( s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');

        //if * is present
        if(j+1 < p.length() && p.charAt(j+1)=='*'){
            //use *
            dp[i][j] = (match && solve(s, p, i+1, j)) || solve(s, p, i, j+2);
            return dp[i][j];
        }
        if(match){
            dp[i][j]= solve(s,p,i+1, j+1);
            return dp[i][j];
        }

        dp[i][j]=false;
        return false;
    }
    public boolean isMatch(String s, String p) {
        int n=s.length(), m=p.length();
        dp = new Boolean[n+1][m+1];

        return solve(s,p,0,0);
    }
}