/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0) return 0;
        intervals.sort(Comparator.comparingInt(i -> i.start));
        PriorityQueue<Interval> heap = new PriorityQueue<>(Comparator.comparingInt(i -> i.end));
        int res = 0;
        for(int i = 0; i < intervals.size(); i++) {
            if(heap.isEmpty() || heap.peek().end > intervals.get(i).start) {
                res++;
            } else {
                heap.poll();
            }
            heap.add(intervals.get(i));
        }
        return res;
        
    }
}
