class Solution {
    int[][] directions = {{0, 1}, {1, 0}};
    int[][] cache;
    int cols;
    int rows;

    public int uniquePaths(int m, int n) {
        cols = n;
        rows = m;

        cache = new int[rows][cols];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }
        return dfs(m, n, 0, 0);
    }

    private int dfs(int m, int n, int row, int col) {
        if(row == rows - 1 && col == cols - 1) {
            return 1;
        }
        if(col >= cols || row >= rows) return 0;
        if(cache[row][col] != -1) {
            return cache[row][col];
        }
       
        return cache[row][col] = dfs(m, n, row + 1, col) + dfs(m, n, row, col + 1);
    }
}
