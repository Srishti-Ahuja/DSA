class Solution {
    public String removeOuterParentheses(String s) {
        int level = 0;
        String res="";

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                if(level!=0)
                    res += s.charAt(i);
                level++;
            }
            else{
                level--;
                if(level!=0)
                    res += s.charAt(i);
            }
        }

        return res;
    }
}