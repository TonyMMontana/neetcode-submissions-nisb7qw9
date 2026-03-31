class Solution {
    int ROWS, COLS;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean dfs(char[][] board, String word, int indx, int row, int col) {
        if(indx == word.length()) {
            return true;
        }

        if(row < 0 || row >= ROWS || col < 0 || col >= COLS || board[row][col] != word.charAt(indx) || board[row][col] == '#') {
            return false;
        }

        board[row][col] = '#';
        boolean res = dfs(board, word, indx + 1, row - 1, col) ||
                      dfs(board, word, indx + 1, row + 1, col) ||
                      dfs(board, word, indx + 1, row, col + 1) ||
                      dfs(board, word, indx + 1, row, col - 1);

        board[row][col] = word.charAt(indx);
        return res;
    }
}
