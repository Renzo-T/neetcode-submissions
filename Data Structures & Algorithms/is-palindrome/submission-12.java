class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length()-1;
        while (l < r) {
            if (!isAlphaNumeric(s.charAt(l))) {
                l++;
            } else if (!isAlphaNumeric(s.charAt(r))) {
                r--;
            } else if (s.charAt(l) != s.charAt(r)) {
                return false;
            } else {
                l++; 
                r--;
            }
        }
        return true;
    }

    private boolean isAlphaNumeric(Character c) {
        return ('A' <= c && c <= 'z') || ('0' <= c && c <= '9');
    }
}
