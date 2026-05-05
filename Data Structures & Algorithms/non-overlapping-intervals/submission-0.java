class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int res = 0;
        int[] cur = intervals[0];
        for(int[] next : intervals) {
            if(cur[1] > next[0]) {
                cur[1] = Math.min(cur[1], next[1]);
                res++;
            } else {
                cur = next;
            }
        }
        return res - 1;
    }
}
