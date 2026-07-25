class Solution {
    int merge(int s, int mid, int e, int[] nums){
        int count=0;
        int j=mid+1; 
        for(int i=s; i<=mid; i++){
            while(j<=e && nums[i] > 2*(long)nums[j])
                j++;

            count += j-(mid+1);
        }

        List<Integer> temp = new ArrayList<>();
        int l=s, r=mid+1;
        while(l<=mid && r<=e){
            if(nums[l]<nums[r]){
                temp.add(nums[l++]);
            }
            else{
                temp.add(nums[r++]);
            }
        }

        while(l<=mid)
            temp.add(nums[l++]);

        while(r<=e)
            temp.add(nums[r++]);

        for(int i=s; i<=e; i++){
            nums[i] = temp.get(i-s);
        }

        return count;
    }

    int mergeSort(int s, int e, int[] nums){
        if(s>=e)
            return 0;

        int pairs = 0;
        int mid = (s+e)/2;
        pairs += mergeSort(s, mid, nums);
        pairs += mergeSort(mid+1, e, nums);
        pairs += merge(s,mid,e,nums);

        return pairs;
    }
    public int reversePairs(int[] nums) {
        int n=nums.length;
        return mergeSort(0, n-1, nums);
    }
}