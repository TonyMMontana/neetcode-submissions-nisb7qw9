class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] arr = matrix[matrix.length-1];

        for(int i =1; i < matrix.length; i++){
            if(matrix[i][0] > target) {
                arr = matrix[i - 1];
                break;
            }
        }
        
        int l = 0;
        int r = arr.length - 1;
        int mid = (r + l) / 2;

        while(l <= r) {
            if(arr[mid] > target) {
                r = mid - 1;
            } else if(arr[mid] < target){
                l = mid + 1;
            } else {
                return true;
            }
            mid = (r + l) / 2;
        }
        return false;
    }
}
