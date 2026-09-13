class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)->{
            if(a[0]==b[0])
                return Integer.compare(a[1], b[1]);
            else
                return Integer.compare(a[0], b[0]);
        });

        int prevS = points[0][0];
        int prevE = points[0][1];
        int count=1;

        for(int i=1; i<points.length; i++){
            if(points[i][0]<=prevE){
                prevE = Integer.min(prevE, points[i][1]);
                prevS = Integer.max(prevS, points[i][0]);
            }
            else{
                prevS = points[i][0];
                prevE = points[i][1];
                count++;
            }
        }

        return count;
    }
}