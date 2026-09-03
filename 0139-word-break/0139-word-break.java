class Solution {
    Boolean[] dp;

    boolean contains(List<String> wordDict, String s) {
        for(String item : wordDict){
            if(item.equals(s))
                return true;
        }

        return false;
    }
    boolean recurse(String s, int idx, List<String> wordDict) {
        if(s.length()==idx)
            return true;

        if(s.length()<idx)
            return false;

        if(dp[idx]!=null)
            return dp[idx];

        for(int i=idx; i<s.length(); i++){
            if(contains(wordDict, s.substring(idx, i+1))){
                if(recurse(s, i+1, wordDict)){
                    dp[idx] = true;
                    return true;
                }
            }
        }

        dp[idx] = false;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()+1];
        return recurse(s,0,wordDict);
    }
}