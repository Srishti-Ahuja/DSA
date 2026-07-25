class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};

        int l=0, r=nums.length-1, mid=0;
        while(l<=r){
            mid = (l+r)/2;

            if(target<=nums[mid]){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        if((r+1)>=nums.length || nums[r+1]!=target)
            return res;

        res[0]=r+1;

        l=0; r=nums.length-1; 
        while(l<=r){
            mid = (l+r)/2;

            if(target<nums[mid]){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        res[1]=l-1;
        return res;
    }
}