class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int l = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int r = 0; r < s2.length(); r++) {
            Character c = s2.charAt(r);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
            // l -1; e -1; c -1
            if (r - l + 1 > s1.length()) {
                Character c2 = s2.charAt(l);
                map.put(c2, map.getOrDefault(c2, 0) + 1);
                if (map.get(c2) == 0) {
                    map.remove(c2);
                }
                l++;
            }
            if (map.size() == 0) {
                return true;
            }
        }
        return false;
    }
}
