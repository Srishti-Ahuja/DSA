class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1, mid;

        while(l<=r){
            mid = (l+r)/2;

            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>=nums[l]){
                //left sorted
                if(nums[l]<=target && target<nums[mid])
                    r=mid-1;
                else
                    l=mid+1;
            }
            else{
                if(nums[r]>=target && target>nums[mid])
                    l=mid+1;
                else
                    r=mid-1;
            }
        }

        return -1;
    }
}