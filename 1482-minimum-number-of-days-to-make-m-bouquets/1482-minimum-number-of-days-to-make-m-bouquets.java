class Solution {
    boolean possible(int day, int[] bloomDay, int m, int k){
        int count = 0; 
        int bouquets = 0; 

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                count++; 
                if (count == k) {
                    bouquets++;
                    count = 0; 
                }
            } else {
                count = 0; 
            }
        }

        return bouquets>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length)
            return -1;

        int low=Integer.MAX_VALUE, high = Integer.MIN_VALUE, ans=-1;
        for(int i=0; i<bloomDay.length; i++){
            low = Integer.min(low, bloomDay[i]);
            high = Integer.max(high, bloomDay[i]);
        }

        while(low<=high){
            int mid = (low+high)/2;

            if(possible(mid, bloomDay, m, k)){
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }

        return ans;
    }
}