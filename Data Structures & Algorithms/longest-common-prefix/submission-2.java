class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length < 1) {
            return "";
        }
        String common = strs[0];
        for(String str : strs) {
            if(str.equals("")) {
                return "";
            }
            if(!common.equals(str)) {
                for(int i = 0; i < str.length() && i < common.length(); i++) {
                    if(common.charAt(i) != str.charAt(i)) {
                        common = common.substring(0, i);
                        continue;
                    }
                }
                if(common.length() > str.length()) {
                    common = str;
                }
            }
        }
        return common;
    }
}