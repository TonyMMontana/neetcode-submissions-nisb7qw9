class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair<String, Integer> pair = new Pair(value, timestamp);
        map.computeIfAbsent(key, k ->  new ArrayList<>()).add(pair);
    }
    
    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> pairs = map.get(key);
        if(pairs == null) {
            return "";
        }
        int l = 0;
        int r = pairs.size() -1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(pairs.get(mid).getValue() > timestamp) {
                r = mid - 1;
            } else if(pairs.get(mid).getValue() < timestamp) {
                l = mid + 1;
            } else {
                return pairs.get(mid).getKey();
            }
        }
        return r < 0 ? "" : pairs.get(r).getKey();
    }
}
