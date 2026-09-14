class NumMatrix {
    int[][] leftsum, fullsum;
    public NumMatrix(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        leftsum = new int[m][n];
        fullsum = new int[m][n];

        for(int i=0; i<m; i++){
            int lsum=0;
            for(int j=0; j<n; j++){
                lsum += matrix[i][j];
                leftsum[i][j]=lsum;
            }
        }

        for(int i=0; i<n; i++){
            fullsum[0][i] = leftsum[0][i];
        }

        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                fullsum[i][j] = fullsum[i-1][j] + leftsum[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1==0 && col1==0)
            return fullsum[row2][col2];
        if(row1==0)
            return fullsum[row2][col2] - fullsum[row2][col1-1];
        if(col1==0)
            return fullsum[row2][col2] - fullsum[row1-1][col2];
            
        return fullsum[row2][col2] - fullsum[row2][col1-1] - fullsum[row1-1][col2] + fullsum[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */