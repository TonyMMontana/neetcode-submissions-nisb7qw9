class Solution {
    Trie trie = new Trie();
    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words) {
            trie.insert(word);
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie.root);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int row, int col, Node node) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }
        char c = board[row][col];
        if(c == '#' || !node.map.containsKey(c)) {
            return;
        }

        board[row][col] = '#';

        node = node.map.get(c);
        if(node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        dfs(board, row + 1, col, node);
        dfs(board, row - 1, col, node);
        dfs(board, row, col + 1, node);
        dfs(board, row, col - 1, node);

        board[row][col] = c;
    }

    private class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node cur = root;
            for(char c : word.toCharArray()) {
                cur.map.putIfAbsent(c, new Node());
                cur = cur.map.get(c);
            }
            cur.word = word;
        }

        public Node search(String word) {
            Node cur = root;
            for(char c : word.toCharArray()) {
                if(!cur.map.containsKey(c)) {
                    return null;
                }
                cur = cur.map.get(c);
            }
            return cur;
        }
    }
    private class Node{
        Map<Character, Node> map = new HashMap<>();
        String word;
    }
}
