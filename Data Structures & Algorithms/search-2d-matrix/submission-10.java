class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length - 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(matrix[mid][0] > target) {
                r = mid - 1;
            } else if(matrix[mid][0] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }

        if(r < 0) {
            return false;
        }
        int idx = r;
        l = 0;
        r = matrix[0].length - 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(matrix[idx][mid] > target) {
                r = mid - 1;
            } else if(matrix[idx][mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
