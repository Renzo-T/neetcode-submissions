class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> row = new HashMap<>();
        Map<Integer, Set<Integer>> col = new HashMap<>();
        Map<Integer, Set<Integer>> square = new HashMap<>();
        // square can be gotten by row/3*3 = col/3

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!Character.isDigit(board[i][j])) {
                    continue;
                }
                int value = board[i][j] - '0';
                if (!(addToMap(row, i, value) && addToMap(col, j, value) && addToMap(square, i / 3 * 3 + j / 3, value))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean addToMap(Map<Integer, Set<Integer>> map, int key, int value) {
        map.putIfAbsent(key, new HashSet<>());
        return map.get(key).add(value);
    }
}
