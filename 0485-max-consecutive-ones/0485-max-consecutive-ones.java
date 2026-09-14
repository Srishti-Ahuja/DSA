class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr=0, mx=0;

        for(int n:nums){
            if(n==1){
                curr++;
                mx = curr>mx ? curr : mx;
            }
            else{
                curr=0;
            }
        }

        return mx;
    }
}