class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0;
        int r = 0;
        int have = 0;
        int need = tMap.size();
        String result = "";

        while(r < s.length()){
            char current = s.charAt(r);
            window.put(current, window.getOrDefault(current, 0) + 1);

            if(tMap.containsKey(current)){
                //update have
                if(window.get(current) == tMap.get(current)) {
                    have++;
                }
            }

            while(need == have) {
                if(!result.equals("")){
                     result = result.length() > r - l + 1 ? s.substring(l, r + 1) : result;
                } else {
                    result = s.substring(l, r + 1);
                }

                current = s.charAt(l);
                window.put(current, window.get(current) - 1);

                if(tMap.containsKey(current)){
                    if(window.get(current) < tMap.get(current)) {
                        have--;
                    }
                }

                if(window.get(current) == 0) {
                    window.remove(current);
                }

                l++;
                //new value for have
                //l++
                //remove from window
                //check length for valid sub and update it
            }


            r++;
        }
        return result;

    }
}
