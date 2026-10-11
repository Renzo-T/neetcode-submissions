class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int l = 0;
        int max = 0;
        
        for (int r = 0; r < s.length(); r++) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }
            max = Math.max(r - l + 1, max);
            charSet.add(s.charAt(r));
        }

        return max;
    }
}
