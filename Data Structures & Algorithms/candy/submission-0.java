class Solution {
    public int candy(int[] ratings) {
        // +1 for higher value
        // -1 for lower value
        // start number at 0;
        // keep running sum
        // add min value seen * ratings to final count
        
        // 4,7,2,9,1,3,4,4,8,10,1
        // 1,2,1,2,1,2,3,3,4,5,4
        // -2,-1,-2,-1,-2,-1,0,0,1,2,1
        
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }

        return Arrays.stream(candies).sum();
    }
}