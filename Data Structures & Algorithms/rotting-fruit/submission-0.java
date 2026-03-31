class Solution {
    int[][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int fruits = 0;
        Queue<Pair<int[], Integer>> rotten = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    fruits++;
                } else if (grid[i][j] == 2) {
                    rotten.add(new Pair<>(new int[]{i, j}, 0));
                }
            }
        }

        int res = 0;
        while(!rotten.isEmpty()) {
            Pair<int[], Integer> pair = rotten.poll();
            int row = pair.getKey()[0];
            int col = pair.getKey()[1];
            int time = pair.getValue();

            for(int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];
                
                if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1) {
                    continue;
                }

                grid[r][c] = 2;
                rotten.add(new Pair<>(new int[] {r, c}, time + 1));
                res = Math.max(time + 1, res);
                fruits--;
            }
        }
        return fruits == 0 ? res : -1;
    }
}
