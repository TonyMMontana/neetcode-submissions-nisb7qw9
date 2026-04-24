class Solution {
    int[][] directions = {{0,1}, {1,0}, {-1, 0}, {0, -1}};
    int[][] cache;

    public int longestIncreasingPath(int[][] matrix) {
        cache = new int[matrix.length][matrix[0].length];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }    
        int res = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int row, int col) {
        if(cache[row][col] != -1) {
            return cache[row][col];
        }   
        
        int max = 1;

        for(int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];

            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {
                if(grid[r][c] > grid[row][col]) {
                    max = Math.max(max, 1 + dfs(grid, r, c));
                } 
            }
        }
        return cache[row][col] = max;
    }
}
