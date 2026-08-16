class Solution {
    public int myAtoi(String s) {
        long res = 0;
        boolean isNeg = false;
        int len = s.length();

        int i=0;
        while(i<len && s.charAt(i)==' ')
            i++;

        if(i<len && s.charAt(i)=='-'){
            isNeg = true;
            i++;
        }
        else if(i<len && s.charAt(i)=='+'){
            i++;
        }

        while(i<len){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                res *= 10;
                res += s.charAt(i)-'0';

                if ((isNeg ? -1:1) * res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if ((isNeg ? -1:1) * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
            else{
                break;
            }
            i++;
        }

        res *= (isNeg ? -1:1);

        return (int)res;
    }
}