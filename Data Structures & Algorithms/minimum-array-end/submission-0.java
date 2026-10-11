class Solution {
    public long minEnd(int nInt, int x) {
        // strictly increasing array of size n, bitwise AND is x
        // return minimum last value
        // x = 1000001 -> 1000001 is first value
        // any 0's can become 1s
        // any 1's must stay
        // if exhausted can add bit to front
        // 5 0s means we can do 32 values thrown in there
        // need to add more 0s sometimes
        // bit wise repesent n - 1. then fill 0s in x then convert to long
        long n = nInt - 1; // 100
        long minEnd = x;   // 011
        long bitMask = 1;

        while (n != 0) { // 100, 10, 1
            if (x % 2 == 0) { // false, true
                if (n % 2 == 1) {
                    minEnd = minEnd | bitMask;
                }
                n >>= 1;
            }
            x >>= 1;
            bitMask <<= 1; // 010, 100
        }
        
        return minEnd;
    }
}