class Solution {

    public String decodeString(String s) {
        return processBracket(s, new int[1]).toString();
    }

    private StringBuilder processBracket(String s, int[] idx) {
        StringBuilder result = new StringBuilder();
        while (idx[0] < s.length() && s.charAt(idx[0]) != ']') {
            char c = s.charAt(idx[0]);
            if(Character.isDigit(c)) {
                int num = 0;
                while (idx[0] < s.length() && Character.isDigit(s.charAt(idx[0]))) {
                    num = num * 10 + (s.charAt(idx[0]) - '0');
                    idx[0]++;
                }
                idx[0]++; // skip '['
                StringBuilder inner = processBracket(s, idx);
                idx[0]++; // skip ']'

                for (int i = 0; i < num; i++) {
                    result.append(inner);
                }
            } else {
                result.append(c);
                idx[0]++;
            }
        }
        return result;
    }
}