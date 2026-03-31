class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<int[]> queu = new LinkedList<>();
        grid[row][col] = '0';
        queu.add(new int[]{row, col});

        while(!queu.isEmpty()) {
            int[] node = queu.poll();
            int r = node[0];
            int c = node[1];

            for(int[] direction : directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];
                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    queu.add(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        } 
    }
}
