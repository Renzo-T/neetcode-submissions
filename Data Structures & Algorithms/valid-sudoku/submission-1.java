class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> columns = new HashMap<>();
        Map<Integer, Set<Integer>> subBoxes = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                int subBox = 3 * (i/3) + (j/3);
                rows.putIfAbsent(i, new HashSet<>());
                columns.putIfAbsent(j, new HashSet<>());
                subBoxes.putIfAbsent(subBox, new HashSet<>());
                if (!(rows.get(i).add(num) && 
                    columns.get(j).add(num) &&
                    subBoxes.get(subBox).add(num))) {
                        return false;
                    }
            }
        }

        return true;
    }
}
