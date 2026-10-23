class Solution {
    public int findJudge(int n, int[][] trust) {
        // trust level arr
        // for each entry incr b's trust. if someone has n level trust return judge
        int[] trustLevel = new int[n + 1];

        for (int[] trustEntry : trust) {
            trustLevel[trustEntry[1]]++;
            trustLevel[trustEntry[0]]--;
        }

        for (int i = 0; i < trustLevel.length; i++) {
            if (trustLevel[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}