class Solution {
    public boolean isAnagram(String s, String t) {
        return isArrayEqual(charArray(s), charArray(t));
    }

    private int[] charArray(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c-'a']++;
        }
        
        return chars;
    }

    private boolean isArrayEqual(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
