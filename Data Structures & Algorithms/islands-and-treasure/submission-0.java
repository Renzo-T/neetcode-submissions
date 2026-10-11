class Solution {
    int[][] directions = new int[][]{
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> treasurePath = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    treasurePath.add(new int[]{i, j});
                }
            }
        }
        
        int distance = 0;
        while (!treasurePath.isEmpty()) {
            int queueSize = treasurePath.size();
            for (int n = 0; n < queueSize; n++) {
                int[] node = treasurePath.poll();
                for (int[] direction : directions) {
                    int i = node[0] + direction[0];
                    int j = node[1] + direction[1];
                    if (isOutOfBoundsOrNotUnseenLand(grid, i, j)) {
                        continue;
                    }
                    grid[i][j] = grid[node[0]][node[1]] + 1;
                    treasurePath.add(new int[]{i, j});
                }
            }

            distance++;
        }
    }

    private static boolean isOutOfBoundsOrNotUnseenLand(int[][] grid, int i, int j) {
        return (i < 0 || i >= grid.length) ||
                (j < 0 || j >= grid[0].length) ||
                grid[i][j] != Integer.MAX_VALUE;
    }
}
