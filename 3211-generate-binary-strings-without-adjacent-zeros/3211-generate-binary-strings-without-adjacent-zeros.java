class Solution {
    List<String> res;

    void build(String s, int n){
        if(n==0){
            res.add(s);
            return;
        }

        if(s.length()==0 || s.charAt(s.length()-1)=='1' )
            build(s+"0", n-1);
        build(s+"1", n-1);
    }

    public List<String> validStrings(int n) {
        res = new ArrayList<>();
        build("", n);

        return res;
    }
}