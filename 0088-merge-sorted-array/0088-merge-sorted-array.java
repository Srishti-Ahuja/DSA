class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=m+n-1;

        int i=m-1, j=n-1;
        while(k>=0){
            if(i==-1){
                nums1[k--]=nums2[j--];
            }
            else if(j==-1){
                break;
            }
            else{
                if(nums2[j]>nums1[i]){
                    nums1[k--]=nums2[j--];
                }
                else{
                    nums1[k--]=nums1[i--];
                }
            }
        }
    }
}