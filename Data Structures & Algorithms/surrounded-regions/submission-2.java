class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for(int i = 0; i < ROWS; i++) {
            if(board[i][0] == 'O') {
                dfs(board, i, 0);
            } 
            if(board[i][COLS - 1] == 'O') {
                dfs(board, i, COLS - 1);
            }
        }
        for(int i = 0; i < COLS; i++) {
            if(board[0][i] == 'O') {
                dfs(board, 0, i);
            } 
            if(board[ROWS - 1][i] == 'O') {
                dfs(board, ROWS - 1, i);
            }
        }

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == 'X' || board[row][col] == 'T') {
            return;
        }
        board[row][col] = 'T';

        for(int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            dfs(board, r, c);
        }
    }
}

