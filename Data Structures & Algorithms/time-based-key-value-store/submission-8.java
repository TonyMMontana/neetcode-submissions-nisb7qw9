class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
        .add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> list = map.get(key);
        if(list == null || list.isEmpty()) {
            return "";
        }

        int l = 0;
        int r = list.size() - 1;

        while(l <= r) {
            int mid = l +(r - l) / 2;
            Pair<Integer, String> pair = list.get(mid);

            if(pair.getKey() > timestamp) {
                r = mid - 1;
            } else if(pair.getKey() < timestamp) {
                l = mid + 1;
            } else {
                return pair.getValue();
            }
        }

        return r >= 0 ? list.get(r).getValue() : "";
    }
}
