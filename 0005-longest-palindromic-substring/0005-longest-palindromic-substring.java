class Solution {
    String res;

    public String longestPalindrome(String s) {
        String res= "";

        //odd length substring
        for(int i=0; i<s.length(); i++){
            int t=0;
            while(t<=i && t<s.length()-i){
                if(s.charAt(i-t)==s.charAt(i+t)){
                    if(1+2*t>res.length())
                        res = s.substring(i-t, i+t+1);
                    t++;
                }
                else{
                    break;
                }
            }
        }

        //even  length substring
        for(int i=0; i<s.length()-1; i++){
            int t=0;
            while(t<=i && t<s.length()-i-1){
                if(s.charAt(i-t)==s.charAt(i+t+1)){
                    if(2*(t+1)>res.length()){
                        System.out.println(i-t+ " " + (i+t+1) +" " +s.substring(i-t, i+t+2));
                        res = s.substring(i-t, i+t+2);
                    }
                    t++;
                }
                else{
                    break;
                }
            }
        }

        return res;
    }
}