class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] cur = intervals[0];
        int counter = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(cur[1] > intervals[i][0]) {
                intervals[i][1] = Math.min(cur[1], intervals[i][1]);
                counter++;
            }
            cur = intervals[i];
        }
        return counter;
    }
}
