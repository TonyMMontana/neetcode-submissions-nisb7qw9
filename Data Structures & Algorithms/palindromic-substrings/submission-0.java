class Solution {
    Map<String, Boolean> cache;
    
    public int countSubstrings(String s) {
        cache = new HashMap<>();
        int count = 0;
        for(int i = 0; i< s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(isPal(i, j, s)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPal(int l, int r, String s){
        if(l>=r){
            return true;
        }
        String key = l + "," + r;
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        if(s.charAt(l) != s.charAt(r)){
            cache.put(key, false);
            return false;
        }
        cache.put(key, isPal(l+1, r-1, s));
        return cache.get(key);
    }
}