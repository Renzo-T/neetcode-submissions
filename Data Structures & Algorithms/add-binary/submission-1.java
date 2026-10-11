class Solution {
    public String addBinary(String a, String b) {
        StringBuilder aSb = new StringBuilder(a).reverse();
        StringBuilder bSb = new StringBuilder(b).reverse();

        StringBuilder results = new StringBuilder();
        int carry = 0;

        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int sum = carry;
            if (i < a.length()) {
                sum += aSb.charAt(i) - '0';
            }
            if (i < b.length()) {
                sum += bSb.charAt(i) - '0';
            }
            carry = sum / 2;
            results.append((char) (sum % 2 + '0'));
        }

        if (carry == 1) {
            results.append('1');
        }


        return results.reverse().toString();
    }
}