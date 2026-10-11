class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            int index = c-'a';
            charCount[index]--;
            if (charCount[index] < 0) {
                return false;
            }
        }
        return true;
    }
}
