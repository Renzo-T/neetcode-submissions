class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ('0' == grid[i][j]) {
                    continue;
                }
                sinkIsland(grid, i, j);
                islands++;
            }
        }

        return islands;
    }

    private void sinkIsland(char[][] grid, int i, int j) {
        if (isOutOfBoundsOrZero(grid, i, j)) {
            return;
        }
        grid[i][j] = '0';
        sinkIsland(grid, i-1, j);
        sinkIsland(grid, i+1, j);
        sinkIsland(grid, i, j-1);
        sinkIsland(grid, i, j+1);
    }

    private boolean isOutOfBoundsOrZero(char[][] grid, int i, int j) {
        return (i < 0 || i >= grid.length) || 
                (j < 0 || j >= grid[0].length) ||
                grid[i][j] == '0';
    }
}
