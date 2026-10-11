class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n/2; layer++) {
            for (int i = layer; i < n - 1 - layer; i++) {
                int top = matrix[layer][i];
                int right = matrix[i][n-1-layer];
                int bot =  matrix[n-1-layer][n-1-i];
                int left = matrix[n-1-i][layer];

                matrix[layer][i] = left;
                matrix[i][n-1-layer] = top;
                matrix[n-1-layer][n-1-i] = right;
                matrix[n-1-i][layer] = bot;
            }
        }
    }
}
