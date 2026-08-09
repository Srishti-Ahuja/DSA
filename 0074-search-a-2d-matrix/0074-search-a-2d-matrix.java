class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //find row
        int low=0, high = matrix.length-1, row = matrix.length-1;
        while(low<=high){
            int mid=(low+high)/2;

            if(matrix[mid][0] == target)
                return true;

            if(matrix[mid][0] > target){
                high = mid-1;
            }
            else{
                row = mid;
                low = mid+1;
            }
        }
        System.out.println(row);
        //find col
        low=0; high = matrix[0].length-1;
        while(low<=high){
            int mid=(low+high)/2;

            if(matrix[row][mid] == target)
                return true;

            if(matrix[row][mid] > target)
                high = mid-1;
        
            else
                low = mid+1;
        }

        return false;
    }
}