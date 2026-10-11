class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!isAlphaNumeric(s.charAt(left))) {
                left++;
            } else if (!isAlphaNumeric(s.charAt(right))) {
                right--;
            } else if (Character.toLowerCase(s.charAt(left)) == (Character.toLowerCase(s.charAt(right)))) {
                left++; 
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return Character.isAlphabetic(c) || (c >= '0' && c <= '9');
    }
}
