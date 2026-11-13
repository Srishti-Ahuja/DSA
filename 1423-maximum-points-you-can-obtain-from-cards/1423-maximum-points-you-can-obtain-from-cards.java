class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left=0, right=cardPoints.length -1, sum=0;
        for(left=0; left<k; left++)
            sum += cardPoints[left];
        left--;

        if(left==right)
            return sum;

        int mxsum = sum;
        while(left>=0){
            sum -= cardPoints[left];
            sum += cardPoints[right];
            left--;
            right--;

            mxsum = Integer.max(mxsum, sum);
        }

        return mxsum;
    }
}