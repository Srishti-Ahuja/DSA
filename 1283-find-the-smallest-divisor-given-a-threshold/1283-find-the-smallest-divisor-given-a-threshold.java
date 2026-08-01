class Solution {
    boolean lessThanThreshold(int divisor, int[] nums, int threshold) {
        int sum=0;
        for(int num : nums){
            sum += Math.ceil((float)num/divisor);
        }

        return sum<=threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1, high=Integer.MIN_VALUE;
        for(int num : nums){
            high = Integer.max(high, num);
        }

        int ans=1;
        while(low<=high){
            int mid=(low+high)/2;

            if( lessThanThreshold(mid, nums, threshold) ){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return ans;
    }
}