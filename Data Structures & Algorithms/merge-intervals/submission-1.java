class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        for(int[] interval : intervals) {
            int curEnd = cur[1];
            int nextStart = interval[0];

            if(curEnd < nextStart) {
                res.add(cur);
                cur = interval;
            } else  {
                cur[1] = Math.max(curEnd, interval[1]);
            }

        }
        res.add(cur);
        return res.toArray(new int[res.size()][]);
    }
}
