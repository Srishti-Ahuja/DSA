class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> {
            if(a[0]!=b[0]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1], b[1]);
        });

        int[][] res = new int[intervals.length][intervals[0].length];
        res[0][0] = intervals[0][0]; res[0][1] = intervals[0][1];
        int l=0;

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]<=res[l][1]){
                res[l][1] = Integer.max(res[l][1], intervals[i][1]);
            }
            else{
                l++;
                res[l][0] = intervals[i][0];
                res[l][1] = intervals[i][1];
            }
        }

        return Arrays.copyOfRange(res, 0, l+1);
    }
}