class Solution {
    int maxArea;

    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j =0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(dfs(grid, i, j), maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }
        
        grid[row][col] = 0;
        return 1
        + dfs(grid, row + 1, col)
        + dfs(grid, row - 1, col)
        + dfs(grid, row, col + 1)
        + dfs(grid, row, col - 1);
    }
}
