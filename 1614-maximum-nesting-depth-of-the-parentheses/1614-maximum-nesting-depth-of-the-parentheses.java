class Solution {
    public int maxDepth(String s) {
        int mx = 0, level = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                level++;
                mx = level>mx ? level : mx;
            }
            else if(s.charAt(i)==')'){
                level--;
            }
        }

        return mx;
    }
}