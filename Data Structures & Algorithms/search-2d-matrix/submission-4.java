class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length*matrix[0].length;

        while (l < r) {
            int m = (r - l) / 2 + l;
            //6
            int mid = matrix[m/matrix[0].length][m%matrix[0].length];
            if (target == mid) {
                return true;
            } else if (target > mid) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return false;
    }
}
