class Solution {
    public String longestCommonPrefix(String[] strs) {
        int ct = 0;
        while (ct < strs[0].length()) {
            char c = strs[0].charAt(ct);
            for (String str : strs) {
                if(ct == str.length() || str.charAt(ct) != c) {
                    return str.substring(0, ct);
                }
            }
            ct++;
        }

        return strs[0];
    }
}