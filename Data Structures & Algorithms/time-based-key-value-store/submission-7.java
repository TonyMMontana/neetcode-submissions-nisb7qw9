class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> pairs = map.get(key);
        if(pairs == null || pairs.isEmpty()) {
            return "";
        }
        int l = 0;
        int r = pairs.size() - 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            Pair<String, Integer> pair = pairs.get(mid);
            if(pair.getValue() > timestamp) {
                r = mid - 1;
            } else if(pair.getValue() < timestamp) {
                l = mid + 1;
            } else {
                return pair.getKey();
            }
        }
        return r >= 0 ? pairs.get(r).getKey() : "";
    }
}
