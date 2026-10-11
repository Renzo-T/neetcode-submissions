class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // gcd length != gcd strings
        // str1 = xxxx; str2 = xx -> str1 + str2 = str2 + str1
        // len (x) is answer call it y. len (str1) = 4y, len(str2) = 2y
        // gcd of those two is y. 

        String onePlusTwo = str1 + str2;
        String twoPlusOne = str2 + str1;

        if (!onePlusTwo.equals(twoPlusOne)) {
            return "";
        }

        int index = gcd(str1.length(), str2.length());
        return str1.substring(0, index);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}