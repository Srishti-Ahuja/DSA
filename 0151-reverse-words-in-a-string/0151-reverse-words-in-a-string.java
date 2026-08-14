class Solution {
    public String reverseWords(String s) {
        String res="";
        String word="";
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)==' '){
                res += word;
                if(word!="")
                    res+= " ";
                word = "";
            }
            else{
                word = s.charAt(i)+word;
            }
        }

        res += word;

        return res.trim();
    }
}