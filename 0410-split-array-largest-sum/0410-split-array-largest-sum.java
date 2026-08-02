class Solution {
    int parts(int[] nums, int size){
        int count=1;
        int sum=0;

        for(int i=0; i<nums.length; i++){
            if(sum+nums[i] > size){
                count++;
                sum=0;
            }
            sum+=nums[i];
        }

        return count;
    }
    public int splitArray(int[] nums, int k) {
        int low=0, high=0, ans=0;
        for(int num:nums){
            low = Integer.max(low, num);
            high+=num;
        }

        while(low<=high){
            int mid = (low+high)/2;
            int partitions = parts(nums, mid);

            if(partitions>k){
                low=mid+1;
            }
            else{
                ans = mid;
                high=mid-1;
            }
        }

        return ans;
    }
}