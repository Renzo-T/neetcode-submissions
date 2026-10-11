class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();

        while (l <= r) {
            int m = (r - l)/2 + l;
            long totalTime = Arrays.stream(piles)
                .mapToLong( pile -> (long) Math.ceil((double) pile / m) )
                .sum();
            if (totalTime > h) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }
}
