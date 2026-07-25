class Solution {
    public int maxProduct(int[] nums) {
        int prod=1, mxprod=0, mx=Integer.MIN_VALUE;
        int n=nums.length;

        for(int i=0; i<n; i++){
            mx = Integer.max(mx, nums[i]);
            prod*=nums[i];
            mxprod = Integer.max(prod, mxprod);

            if(prod==0)
                prod=1;
        }

        prod=1;
        for(int i=n-1; i>=0; i--){
            prod*=nums[i];
            mxprod = Integer.max(prod, mxprod);

            if(prod==0)
                prod=1;
        }

        if(mxprod==0)
            return mx;
        return mxprod>mx ? mxprod:mx ;
    }
}