class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>());
        return res;
    }

    private void dfs(String s, int i, List<String> comb){
        if(i >= s.length()){
            res.add(new ArrayList<>(comb));
            return;
        }
        for(int j = i + 1; j <= s.length(); j++) {
            String cur = s.substring(i, j);
            if(isPolindrome(cur)){
                comb.add(cur);
                dfs(s, j, comb);
                comb.remove(comb.size() - 1);
            }
        }    
    }

    private boolean isPolindrome(String s){
        int l = 0;
        int r = s.length() - 1;
        while(l<=r){
            if(s.charAt(l) !=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}