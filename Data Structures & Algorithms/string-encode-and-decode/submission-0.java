class Solution {

    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int length = 0;
        for(int i = 0; i < strs.size(); i++) {
            length = strs.get(i).length();
            sb.append(length).append("#").append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int l = 0;
        int r = 0;

        while (r < str.length()) {
            if (str.charAt(r) == '#') {
                int length = Integer.parseInt(str.substring(l, r));
                l = r + 1;
                list.add(str.substring(l, l + length));
                r = l + length;
                l += length;
            }
            r++;
        }
        return list;
    }
}
