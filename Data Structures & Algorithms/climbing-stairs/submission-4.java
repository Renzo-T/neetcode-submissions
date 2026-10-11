class Solution {
    public int climbStairs(int n) {
        int twoBehind = 1;
        int oneBehind = 1;

        for (int i = 2; i <= n; i++) {
            int steps = oneBehind + twoBehind;
            twoBehind = oneBehind;
            oneBehind = steps;
        }

        return oneBehind;
    }

}
