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
        // sort interval earliest start then by earlies finish.
        // 0, 40
        // 5, 10 <- interlap +1, use stack
        // 11, 40 <- punt the 5,10 then andd 11,40, then punt both

        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);

        PriorityQueue<Interval> activeIntervals = new PriorityQueue<>((i1, i2) -> 
            i1.end - i2.end
        );  

        int time = 0;
        int maxSize = 0;
        for (Interval interval : intervals) {
            time = interval.start;
            activeIntervals.offer(interval);
            while (time >= activeIntervals.peek().end) {
                activeIntervals.poll();
            }
            maxSize = Math.max(maxSize, activeIntervals.size());
        }

        return maxSize;
    }
}
