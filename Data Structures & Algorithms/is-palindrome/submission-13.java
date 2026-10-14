class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            Character leftChar = s.charAt(l);
            Character rightChar = s.charAt(r);
            System.out.println(l + "_" + r);
            if (!isAlphaNumeric(leftChar)) {
                l++;
            } else if (!isAlphaNumeric(rightChar)) {
                r--;
            } else if (Character.toLowerCase(leftChar) == 
                    Character.toLowerCase(rightChar)) {
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isAlphaNumeric(Character c) {
        return (c >= 'A' && c <= 'Z' || 
                c >= 'a' && c <= 'z' || 
                c >= '0' && c <= '9');
    }
}
