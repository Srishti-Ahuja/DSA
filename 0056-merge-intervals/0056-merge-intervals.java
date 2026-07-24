class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));

        int n=intervals.length;
        int[][] res = new int[n][2];
        int k=0;
        for(int i=0; i<n; i++){
            if(k==0){
                //res is empty
                res[0] = intervals[i];
                k++;
            }
            else{
                if(intervals[i][0]<=res[k-1][1]){
                    //Overlapping
                    res[k-1][1] = Integer.max(res[k-1][1], intervals[i][1]);
                }
                else{
                    //Not overlapping
                    res[k] = intervals[i];
                    k++;
                }
            }
        }

        return Arrays.copyOf(res,k);
    }
}