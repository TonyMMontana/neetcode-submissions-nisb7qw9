class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] cur = intervals[0];
        List<int[]> res = new ArrayList<>();
        for(int[] next : intervals) {
            if(cur[1] < next[0]) {
                res.add(cur);
                cur = next;
            } else {
                cur[1] = Math.max(next[1], cur[1]);
            }
        }
        res.add(cur);
        return res.toArray(new int[res.size()][]);
    }
}
