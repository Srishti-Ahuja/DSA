class Solution {
    int max(int[][] mat, int col){
        int n=mat.length;

        int maxRow = 0;
        for(int i = 0; i < n; i++){
            if(mat[i][col] > mat[maxRow][col]){
                maxRow = i;
            }
        }

        return maxRow;
    }
    public int[] findPeakGrid(int[][] mat) {
        int[] res = {-1,-1};
        int n=mat.length, m=mat[0].length;

        int l=0, r=m-1, i=0;

        while(l<=r){
            int mid=(l+r)/2;
            i = max(mat, mid);

            int left = mid>0 ? mat[i][mid-1] : -1;
            int right = mid<m-1 ? mat[i][mid+1] : -1;

            if((left < mat[i][mid]) && (right < mat[i][mid])){
                res[0]=i;
                res[1]=mid;
                return res;
            }

            if(mat[i][mid]>right){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        return res;
    }
}