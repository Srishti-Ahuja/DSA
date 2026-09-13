class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum=0;

        for(int i=nums.length-1; i>=0; i--){
            sum += nums[i];
        }

        for(int i=0; i<nums.length; i++){
            sum -= nums[i];
            if(sum==0){
                return i;
            }

            sum-=nums[i];
        }

        return -1;
    }
}