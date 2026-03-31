class TimeMap {
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(value, timestamp);
        List<Pair> pairs = map.get(key);
        if(pairs == null) {
            pairs = new ArrayList<Pair>();
        }
        pairs.add(pair);
        map.put(key, pairs);
    }
    
    public String get(String key, int timestamp) {
        List<Pair> pairs = map.get(key);
        if(pairs == null) {
            return "";
        }
        int l = 0;
        int r = pairs.size() - 1;
        int answer = -1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if (pairs.get(mid).timestamp <= timestamp) {
                l = mid + 1;
                answer = mid;
            } else {
                r = mid - 1;
            }
        }
        return answer == -1 ? "" : pairs.get(answer).value;
    }

    private class Pair{
        String value;
        int timestamp;

        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
