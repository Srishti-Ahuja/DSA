class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prod = new int[nums.length];

        int prev = 1;
        for(int i=nums.length-1; i>=0; i--){
            prod[i] = prev;
            prev *= nums[i]; 
        }

        prev=1;
        for(int i=0; i<nums.length; i++){
            prod[i] = prev*prod[i];
            prev *= nums[i];
        }

        return prod;
    }
}