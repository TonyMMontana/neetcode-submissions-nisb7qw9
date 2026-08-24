class Solution {
    public boolean isValidSudoku(char[][] board) {
       Set<Character> row = new HashSet<>();
       Set<Character> col = new HashSet<>();

       for(int i = 0; i < board.length; i++) {
        for(int j = 0; j < board[0].length; j++) {
            if(board[j][i] != '.' && !row.add(board[j][i])) {
                return false;
            }
            if(board[i][j] != '.' && !col.add(board[i][j])) {
                return false;
            }
        }
        row = new HashSet<>();
        col = new HashSet<>();
       }

       Map<String, Set<Character>> map  = new HashMap<>();

       for(int i = 0; i < board.length; i++) {
        for(int j = 0; j < board[0].length; j++) {
            String key = i / 3 + "," + j/3;
            Set<Character> set = map.getOrDefault(key, new HashSet<>());
            if(board[i][j] != '.' && !set.add(board[i][j])) {
                return false;
            }
            map.put(key, set);
        }
       }
       return true;
    }
}
