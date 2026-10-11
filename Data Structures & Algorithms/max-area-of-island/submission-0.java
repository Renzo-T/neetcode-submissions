class Solution {
    private int[][] directions = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public int maxAreaOfIsland(int[][] grid) {
        int maxIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                maxIsland = Math.max(maxIsland, sinkIsland(grid, i, j));
            }
        }

        return maxIsland;
    }

    private int sinkIsland(int[][] grid, int i, int j) {
        if (isOutOfBoundsOrZero(grid, i, j)) {
            return 0;
        }
        grid[i][j] = 0;
        int size = 1;
        for (int[] direction : directions) {
            size += sinkIsland(grid, i + direction[0], j + direction[1]);
        }
        return size;
    }

    private boolean isOutOfBoundsOrZero(int[][] grid, int i, int j) {
        return (i < 0 || i >= grid.length) || 
                (j < 0 || j >= grid[0].length) ||
                grid[i][j] == 0;
    }
}
