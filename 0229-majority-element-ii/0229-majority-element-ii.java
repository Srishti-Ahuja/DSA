class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1=0, cnt2=0, n=nums.length;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(cnt1==0 && nums[i]!=ele2){
                ele1 = nums[i];
            }
            else if(cnt2==0 && nums[i]!=ele1){
                ele2 = nums[i];
            }

            if(nums[i]==ele1){
                cnt1++;
            }
            else if(nums[i]==ele2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        cnt1=0; cnt2=0;
        for(int i=0; i<n; i++){
            if(nums[i]==ele1) cnt1++;
            if(nums[i]==ele2) cnt2++;
        }

        if(cnt1>Math.floor(n/3.0))
            res.add(ele1);
        if(cnt2>Math.floor(n/3.0))
            res.add(ele2);

        return res;
    }
}