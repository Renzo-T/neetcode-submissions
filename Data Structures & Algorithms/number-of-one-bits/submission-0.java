class Solution {
    public int hammingWeight(int n) {
        // 10 -1 = 01
        // 01 -1 = 00
        // flips right most 1 bit. bit wise and with original eliminates last 1 bit
        int bits = 0;
        while (n != 0) {
            n &= n-1;
            bits++;
        }

        return bits;
    }
}
