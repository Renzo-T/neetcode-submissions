class Solution {
    private static int[][] directions = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }
                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }
        
        while (fresh > 0 && !q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                int[] node = q.poll();
                for (int[] direction : directions) {
                    int r = node[0] + direction[0];
                    int c = node[1] + direction[1];
                    if (isOutOfBoundOrNotFresh(grid, r, c)) {
                        continue;
                    }
                    grid[r][c] = 2;
                    q.offer(new int[]{r, c});
                    fresh--;
                }
            }
            time++;
        }
        return fresh > 0 ? -1 : time;
    }

    private static boolean isOutOfBoundOrNotFresh(int[][] grid, int r, int c) {
        return (r < 0 || r >= grid.length) ||
                (c < 0 || c >= grid[0].length) ||
                grid[r][c] != 1;
    }
}
