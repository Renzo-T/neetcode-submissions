class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = findRow(matrix, target);
        if (i < 0) {
            return false;
        }
        int j = Arrays.binarySearch(matrix[i], target);
        return j >= 0;
    }

    private int findRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (matrix[mid][0] <= target && 
                    (mid == matrix.length - 1 || matrix[mid + 1][0] > target)) {
                return mid;
            } else if (matrix[mid][0] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }
}
