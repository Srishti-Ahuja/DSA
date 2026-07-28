class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int mx=0;
        for(int x:piles)
            mx = Integer.max(mx, x);

        if(piles.length==h)
            return mx;

        int l=1, r=mx;
        int ans=mx;
        while(l<=r){
            int mid = (l+r)/2;

            int hours=0;
            for(int x:piles){
                hours += Math.ceil((double)x/mid);
            }

            if(h<hours){
                //increase speed
                l=mid+1;
            }
            else{
                r=mid-1;
                ans = mid;
            }
        }

        return ans;
    }
}