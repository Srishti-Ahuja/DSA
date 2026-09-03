class Solution {
    public boolean uniformArray(int[] nums1) {
        int countOdd=0, countEven=0;
        int minEven=Integer.MAX_VALUE, minOdd=Integer.MAX_VALUE;

        for(int n:nums1){
            if((n&1)==1){
                countOdd++;
                minOdd = n<minOdd ? n : minOdd;
            }
            else{
                countEven++;
                minEven = n<minEven ? n : minEven;
            }
        }

        if(countOdd==nums1.length || countEven==nums1.length)
            return true;

        return minEven - minOdd >= 1;
    }
}