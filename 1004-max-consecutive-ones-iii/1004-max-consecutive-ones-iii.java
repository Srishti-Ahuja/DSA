class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int count=0, left=0, right=0, mx=0;

        while(right<n){
            if(nums[right]==0){
                if(k>0)
                    k--;
                else{
                    while(left<right && nums[left]!=0)
                        left++;
                    left++;
                }
            }

            right++;

            count = right-left;
            mx = Integer.max(mx, count);

            System.out.println(left+" "+ right+" "+ count +" "+mx);
        }
        
        return mx;
    }
}