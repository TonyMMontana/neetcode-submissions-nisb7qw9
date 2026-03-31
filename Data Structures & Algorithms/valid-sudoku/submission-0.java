class Solution {
    public boolean isValidSudoku(char[][] board) {
         Set<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            set.clear();
            for(int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            set.clear();
            for(int j = 0; j < 9; j++) {
                if (board[j][i] != '.' && !set.add(board[j][i])) {
                    return false;
                }
            }
        }

        Map<String, Set<Character>> map = new HashMap();

        for (int i = 0; i < board.length; i++) {
            set.clear();
            for(int j = 0; j < 9; j++) {
                String key = i/3 + "," + j/3;
                map.putIfAbsent(key, new HashSet<Character>());
                Set<Character> square = map.get(key);
                if(board[i][j] != '.' && !square.add(board[i][j])) {
                    return false;
                }
            }
        }
    

        return true;
    }
}
