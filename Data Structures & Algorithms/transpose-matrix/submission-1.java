class Solution {
    public int[][] transpose(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;

        if (ROWS == COLS) {
            for (int r = 1; r < ROWS; r++) {
                for (int c = 0; c < r; c++) {
                    int tmp = matrix[r][c];
                    matrix[r][c] = matrix[c][r];
                    matrix[c][r] = tmp;
                }
            }

            return matrix;
        }


        int[][] transposed = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }

}