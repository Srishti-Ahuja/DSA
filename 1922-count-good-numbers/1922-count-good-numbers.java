class Solution {
    int MOD = 1000000007;
    long power(int base, long exp){
        if(exp==1)
            return base;
        if(exp==0)
            return 1;

        long half = power(base,exp/2) % MOD;
        if(exp%2==0){
            return (half*half)%MOD;
        }
        return ((base * half) % MOD * half) % MOD;
    }
    public int countGoodNumbers(long n) {
        if(n==0)
            return 0;

        if(n==1)
            return 5;

        long odd = n/2;
        long even = (n+1)/2;

        return (int)(power(5,even)%MOD * power(4,odd)%MOD)%MOD;
    }
}