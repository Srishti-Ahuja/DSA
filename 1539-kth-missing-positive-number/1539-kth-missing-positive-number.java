class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length-1;

        if(k<arr[0])
            return k;

        while(low<=high){
            int mid = (low+high)/2;

            //missing value upto arr[mid]
            int missing = arr[mid] - (mid+1);
        
            if(missing<k)
                low = mid+1;
            else
                high = mid-1;
        }

        return high+k+1;
    }
}