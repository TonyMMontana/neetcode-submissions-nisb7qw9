class Solution {
    List<List<String>> res = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i =0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        dfs(n, 0, board);
        return res;
    }

    private void dfs(int n, int row, char[][] board) {
        if(row == n) {
            List<String> copy = new ArrayList<>();
            for(char[] arr : board) {
                copy.add(new String(arr));
            }
            res.add(copy);
            return;
        }
        for(int c = 0; c < n; c++) {
            if(cols.contains(c) || posDiag.contains(row + c) || negDiag.contains(row - c)) {
                continue;
            }
            cols.add(c);
            posDiag.add(row + c);
            negDiag.add(row - c);
            board[row][c] = 'Q';

            dfs(n, row + 1, board);

            cols.remove(c);
            posDiag.remove(row + c);
            negDiag.remove(row - c);
            board[row][c] = '.';
        }
    }
    //dfs(state) {
    // if(state complete) {
    //  res.add(state)
    //}
    //for each valid choise from current state
    //made choise
    //dfs
    //undo choise
    //
    //}
}
