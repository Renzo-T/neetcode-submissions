class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        if (row == -1) {
            return false;
        }

        int l = 0;
        int r = matrix[0].length;
        
        while (l < r) {
            int m = (r - l) / 2 + l;

            if (matrix[row][m] == target) {
                return true;
            } else if (matrix[row][m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

    private int findRow(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length;
        int n = matrix[0].length;

        while (l < r) {
            int m = (r - l) / 2 + l;

            if (matrix[m][0] > target) {
                r = m;
            } else if (matrix[m][n-1] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }

        return -1;
    }
}
