class Solution {
    Map<Character, String> map = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5',
         "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );

    List<String> res;
    public List<String> letterCombinations(String digits) {
        //create string from digits
        //then use general backtraging to get all combinaitons
        res = new ArrayList();
        if(digits.isEmpty()) return res;
        String comb = null;
        dfs(digits, 0, new StringBuilder());
        return res;
    }

    private void dfs(String digits, int i, StringBuilder comb) {
        if(i == digits.length()) {
            res.add(comb.toString());
            return;
        }

        String letters =  map.get(digits.charAt(i));
        for(char c : letters.toCharArray()) {
            dfs(digits, i + 1, comb.append(c));
            comb.deleteCharAt(comb.length() - 1);

        }
    }
}
