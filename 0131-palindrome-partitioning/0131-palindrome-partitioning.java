class Solution {
    List<List<String>> res;

    boolean ispal(String s) {
        int n=s.length();

        for(int i=0; i<n/2; i++){
            if(s.charAt(i)!=s.charAt(n-i-1)) 
                return false;
        }

        return true;
    }

    void recurse(String s, int idx, ArrayList<String> ans){
        if(idx==s.length()){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int i=idx; i<s.length(); i++){
            if(ispal(s.substring(idx, i+1))){
                ans.add(s.substring(idx, i+1));
                recurse(s, i+1, ans);
                ans.remove(ans.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        res = new ArrayList<List<String>>();
        recurse(s, 0, new ArrayList<>());
        return res;
    }
}