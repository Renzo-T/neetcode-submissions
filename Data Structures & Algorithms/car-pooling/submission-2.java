class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] line = new int[1001];
        for (int[] trip : trips) {
            line[trip[1]] += trip[0];
            line[trip[2]] -= trip[0];
        }

        int passengers = 0;
        for (int i = 0; i < line.length; i++) {
            passengers += line[i];
            if (passengers > capacity) {
                return false;
            }
        }

        return true;
    }
}