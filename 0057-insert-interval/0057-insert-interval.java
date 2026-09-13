class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];

        if(intervals.length==0){
            res[0][0] = newInterval[0]; res[0][1] = newInterval[1];
            return res;
        }

        int l=0;
        boolean placed = false;

        if(newInterval[1]<intervals[0][0]){
            res[0][0] = newInterval[0]; res[0][1] = newInterval[1];
            l++;
            placed=true;
        }

        res[l][0] = intervals[0][0]; res[l][1] = intervals[0][1];

        for(int i=1; i<intervals.length; i++){
            if(!placed){
                if(newInterval[0]<=res[l][1]){
                    //merge
                    res[l][0] = Integer.min(res[l][0], newInterval[0]);
                    res[l][1] = Integer.max(res[l][1], newInterval[1]);
                    placed=true;
                }
                else if(newInterval[1]<intervals[i][0]){
                    l++;
                    res[l][0] = newInterval[0]; res[l][1] = newInterval[1];
                    placed=true;
                }
            }

            //next entry from intervals
            if(intervals[i][0]<=res[l][1]){
                //merge
                res[l][0] = Integer.min(res[l][0], intervals[i][0]);
                res[l][1] = Integer.max(res[l][1], intervals[i][1]);
            }
            else{
                //new addition
                l++;
                res[l][0] = intervals[i][0];
                res[l][1] = intervals[i][1];
            }
            
        }

        if(!placed){
            if(newInterval[0]<=res[l][1]){
                //merge
                res[l][0] = Integer.min(res[l][0], newInterval[0]);
                res[l][1] = Integer.max(res[l][1], newInterval[1]);
                placed=true;
            }
            else{
                l++;
                res[l][0] = newInterval[0]; res[l][1] = newInterval[1];
            }
        }

        return Arrays.copyOfRange(res,0,l+1);
    }
}