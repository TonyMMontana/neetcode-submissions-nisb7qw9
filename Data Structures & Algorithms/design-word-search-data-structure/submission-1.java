class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for(char c : word.toCharArray()){
            cur.map.putIfAbsent(c, new Node());
            cur = cur.map.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        Node cur = root;
        int i = 0;
        for(char c : word.toCharArray()){
            if(c != '.' && !cur.map.containsKey(c)){
                return false;
            }
            if(c == '.'){
                return dfs(word, cur, i);
            }
            cur = cur.map.get(c);
            i++;
        }
        return cur.isWord;
    }

    private boolean dfs(String word, Node cur, int idx){
        if(cur == null){
            return false;
        }
        if(idx == word.length()){
            return cur.isWord;
        }

        char c = word.charAt(idx);
        
        if(c == '.') {
            for(Node next : cur.map.values()){
               if(dfs(word, next, idx +1)) return true;
            }
            return false;
        }
        
        return dfs(word, cur.map.get(c), idx +1);
    }

    private class Node {
        Map<Character, Node> map = new HashMap<>();
        boolean isWord;
    }
}
