class Solution {
    int[][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for(int i =0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int r = node[0];
            int c = node[1];

            for(int[] direction : directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];
                int distance = 0;

                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] != 2147483647) {
                    continue;
                }
                grid[nr][nc] = grid[r][c] + 1;
                queue.add(new int[]{nr, nc});
            }
        }
    }
}
