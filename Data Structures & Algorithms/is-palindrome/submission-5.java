class Solution {
    public boolean isPalindrome(String s) {
        int leftIdx = 0;
        int rightIdx = s.length() - 1;
        while (leftIdx < rightIdx) {
            if (!Character.isLetterOrDigit(s.charAt(leftIdx))) {
                leftIdx++;
            } else if (!Character.isLetterOrDigit(s.charAt(rightIdx))) {
                rightIdx--;
            } else if (Character.toLowerCase(s.charAt(leftIdx)) != 
                    Character.toLowerCase(s.charAt(rightIdx))) {
                return false;
            } else {
                leftIdx++;
                rightIdx--;
            }
        }
        return true;
    }
}
