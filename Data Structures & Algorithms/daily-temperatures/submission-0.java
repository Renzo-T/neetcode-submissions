class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // if less jump
        int[] days = new int[temperatures.length];
        days[temperatures.length - 1] = 0;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (temperatures[j] <= temperatures[i] && days[j] != 0) {
                j += days[j];
            }
            if (temperatures[j] > temperatures[i]) {
                days[i] = j-i;
            } else {
                days[i] = 0;
            }
        }

        return days;
    }
}
