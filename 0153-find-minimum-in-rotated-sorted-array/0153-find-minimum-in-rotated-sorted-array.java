class Solution {
    public int findMin(int[] nums) {
        int l=0, r=nums.length-1, mid, min = Integer.MAX_VALUE;

        while(l<=r){
            mid = (l+r)/2;
            min = Integer.min(min, nums[mid]);

            if(nums[mid]>nums[r]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }

        return min;
    }
}