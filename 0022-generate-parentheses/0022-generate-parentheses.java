class Solution {
    List<String> res;

    void build(String s, int n, int open, int close) {
        if(open==n && close==n){
            res.add(s);
            return;
        }

        if(open<n){
            build(s+"(", n, open+1, close);
        }
        if(close<open){
            build(s+")", n, open, close+1);
        }
    }
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        build("", n, 0, 0);

        return res;
    }
}