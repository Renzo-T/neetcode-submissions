class Solution {
    private class Interval implements Comparable<Interval>{
        int start;
        int end;

        public Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        public int compareTo(Interval i2) {
            if (this.start != i2.start) {
                return this.start - i2.start;
            } else {
                return this.end - i2.end;
            }
        }
    }

    public int eraseOverlapIntervals(int[][] primativeIntervals) {
        List<Interval> intervals = new ArrayList<>();
        Arrays.stream(primativeIntervals).forEach(interval -> 
                intervals.add(new Interval(interval)));
        intervals.sort(Comparator.naturalOrder());
        int ct = 0;
        int endInterval = Integer.MIN_VALUE;
        
        for (Interval interval : intervals) {
            if (interval.start < endInterval) {
                ct++;
                endInterval = Math.min(interval.end, endInterval);
            } else {
                endInterval = interval.end;
            }
        }

        return ct;
    }
}
