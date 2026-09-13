class Solution {
    public int maxProduct(int[] nums) {
        int mxprod = Integer.MIN_VALUE, mx = Integer.MIN_VALUE;

        int prod=1;
        for(int i=0; i<nums.length; i++){
            prod *= nums[i];
            mxprod = Integer.max(prod, mxprod);
            mx = Integer.max(mx, nums[i]);

            if(prod==0)
                prod=1;
        }

        prod=1;
        for(int i=nums.length-1; i>=0; i--){
            prod *= nums[i];
            mxprod = Integer.max(prod, mxprod);

            if(prod==0)
                prod=1;
        }

        return Integer.max(mxprod, mx);
    }
}