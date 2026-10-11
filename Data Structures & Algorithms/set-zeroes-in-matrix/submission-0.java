class Solution {
    public void setZeroes(int[][] matrix) {
        boolean zeroRow = false;
        boolean zeroCol = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                zeroCol = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                zeroRow = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = matrix.length-1; i >= 0; i--) {
            for (int j = matrix[0].length-1; j >= 0; j--) {
                if (i == 0 && zeroRow) {
                    matrix[i][j] = 0;
                } else if (j == 0 && zeroCol) {
                    matrix[i][j] = 0;
                }
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
