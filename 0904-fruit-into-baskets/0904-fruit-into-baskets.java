class Solution {
    public int totalFruit(int[] fruits) {
        int mx=0, n=fruits.length;
        Integer first =null, second =null;

        int left=0, right=0;
        while(right<n){
            if(first==null || first==fruits[right]){
                first=fruits[right];
            }
            else if(second==null || second==fruits[right]){
                second=fruits[right];
            }
            else{
                first = fruits[right-1];
                second = fruits[right];

                left=right - 1;
                while(left>0 && fruits[left-1]==first)
                    left--;

            }
            
            right++;
            mx = Integer.max(mx, right-left);
        }

        return mx;
    }
}