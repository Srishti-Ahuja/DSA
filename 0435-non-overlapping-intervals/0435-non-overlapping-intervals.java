class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            if(a[0]==b[0])
                return Integer.compare(a[1], b[1]);
            else
                return Integer.compare(a[0], b[0]);
        });

        int count=0, prevS=intervals[0][0], prevE=intervals[0][1];

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]<prevE){
                //remove
                count++;
                prevE = Integer.min(prevE, intervals[i][1]);
            }
            else{
                prevE = Integer.max(prevE, intervals[i][1]);
            }
        }

        return count;
    }
}