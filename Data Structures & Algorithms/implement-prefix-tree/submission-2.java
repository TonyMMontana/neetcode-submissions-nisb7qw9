class PrefixTree {
    Node root;

    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) { 
        Node node = root;

        for(char c : word.toCharArray()) {
            node.map.putIfAbsent(c, new Node());
            node = node.map.get(c);
        }           
        node.isWord = true;

        // dfs(0, word, root);
    }

    public boolean search(String word) {
        Node node = itterate(word);
        return node != null ? node.isWord : false;
    }

    public boolean startsWith(String prefix) {
        Node node = itterate(prefix);
        return node != null;
    }

    private Node itterate(String word) {
        Node node = root;
        for(char c : word.toCharArray()) {
            if(!node.map.containsKey(c)) {
                return null;
            }
            node = node.map.get(c);
        }
        return node;
    }

    private void dfs(int i, String word, Node node) {
        if(i == word.length()) {
            node.isWord = true;
            return;
        } 
        node.map.computeIfAbsent(word.charAt(i), k -> new Node());
        dfs(i + 1, word, node.map.get(word.charAt(i)));
    }

    private class Node {
        Map<Character, Node> map = new HashMap<>();
        boolean isWord;
    }
}
