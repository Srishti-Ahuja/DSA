class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int n=intervals.length;
        int prevS = intervals[0][0], prevE = intervals[0][1];

        int[][] res = new int[n][2];
        int k=0;

        for(int i=1; i<n; i++){
            if(intervals[i][0]<=prevE){
                //merged
                prevE = Integer.max(prevE, intervals[i][1]);
            }
            else{
                //separate
                res[k][0] = prevS;
                res[k][1] = prevE;
                k++;

                prevS = intervals[i][0];
                prevE = intervals[i][1];
            }
        }

        res[k][0] = prevS;
        res[k][1] = prevE;

        return Arrays.copyOf(res, k+1);
    }
}