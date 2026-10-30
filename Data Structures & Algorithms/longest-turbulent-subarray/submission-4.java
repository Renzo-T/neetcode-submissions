class Solution {
    public int maxTurbulenceSize(int[] arr) {
        // two pointers l, r
        int max = 1;
        int l = 0;
        int r = 1;

        while (r < arr.length) {
            if (arr[r] == arr[r-1]) {
                l = r++;
                continue;
            }
            if (r - l > 1) {
                if (arr[r-2] > arr[r-1] && arr[r] > arr[r-1] ||
                    arr[r-2] < arr[r-1] && arr[r] < arr[r-1] ) {
                        max = Math.max(max, r-l+1);
                        r++;
                } else {                 
                    l = r-1;
                    r++;
                }
            } else {
                r++;
                max = Math.max(max, 2);
            }
        }

        return max;
    }
}