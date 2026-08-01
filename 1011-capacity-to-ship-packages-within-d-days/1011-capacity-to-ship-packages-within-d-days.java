class Solution {
    boolean possibleInDays(int capacity, int[] weights, int days){
        int day_count = 1;

        int sum=0;
        for(int item:weights){
            if(sum+item > capacity){
                day_count++;
                sum = 0;
            }

            sum+=item;
        }

        return day_count <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        for(int item:weights){
            low = Integer.max(low, item);
            high += item; 
        }

        int ans=-1;
        while(low<=high){
            int mid = (low+high)/2;

            if(possibleInDays(mid, weights, days)){
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