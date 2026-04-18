class Solution {
    int[][] directions = {{0, 1}, {1, 0}};
    int[][] cache;

    public int uniquePaths(int m, int n) {
        cache = new int[m][n];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }
        return dfs(m, n, 0, 0);
    }

    private int dfs(int m, int n, int row, int col) {
        if(row == m - 1 && col == n - 1) {
            return 1;
        }
        if(col >= n || row >= m) return 0;
        if(cache[row][col] != -1) {
            return cache[row][col];
        }
       
        return cache[row][col] = dfs(m, n, row + 1, col) + dfs(m, n, row, col + 1);
    }
}
