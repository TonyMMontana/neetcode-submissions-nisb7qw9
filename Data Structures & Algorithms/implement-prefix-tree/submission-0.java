class PrefixTree {
    Node root;

    public PrefixTree() {
         root = new Node();
         root.map = new HashMap<>();
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
        Node node = root;
        for(char c : word.toCharArray()) {
            node = node.map.getOrDefault(c, new Node());
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
         Node node = root;
        for(char c : prefix.toCharArray()) {
            if(!node.map.containsKey(c)) {
                return false;
            }
            node = node.map.get(c);
        }
        return true;
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
