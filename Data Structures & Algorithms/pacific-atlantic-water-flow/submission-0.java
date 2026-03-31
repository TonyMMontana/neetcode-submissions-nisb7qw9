class Solution {
    private int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       int ROWS = heights.length; 
       int COLS = heights[0].length;
       boolean[][] pac= new boolean[ROWS][COLS];
       boolean[][] atl= new boolean[ROWS][COLS];

       for(int i =0; i < COLS; i++) {
        dfs(0, i, pac, heights);
        dfs(ROWS - 1, i, atl, heights);
       }
       for(int i = 0; i < ROWS; i++) {
        dfs(i, 0, pac, heights);
        dfs(i, COLS - 1, atl, heights);
       }

       List<List<Integer>> res = new ArrayList<>();
       for(int i =0; i < ROWS; i++) {
        for(int j = 0; j < COLS; j++) {
            if(atl[i][j] && pac[i][j]) {
                res.add(List.of(i, j));
            }
        }
       }
       return res;
    }

    private void dfs(int row, int col, boolean[][] ocean, int[][] heights) {
        ocean[row][col] = true;
        for(int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length && !ocean[nr][nc] && heights[nr][nc] >= heights[row][col]) {
                dfs(nr, nc, ocean, heights);
            } 
        }
    }
}
