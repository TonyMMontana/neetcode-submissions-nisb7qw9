class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        
        dfs(n, 0, 0, "");
        return res;
    }

    private void dfs(int n, int open, int close, String parenthesis) {
        if(open == close && open == n) {
            res.add(parenthesis);
            return;
        }
        if(open > close) {
            dfs(n, open, close + 1, parenthesis + ")");
        }
        if(open < n) {
            dfs(n, open + 1, close, parenthesis + "(");   
        }
    }
}
