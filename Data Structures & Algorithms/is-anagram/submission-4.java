class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> letters = new HashMap<>();
        for (Character c : s.toCharArray()) {
            letters.put(c, letters.getOrDefault(c, 0) + 1);
        }

        for (Character c : t.toCharArray()) {
            letters.put(c, letters.getOrDefault(c, 0) - 1);
            if (letters.get(c) == 0) {
                letters.remove(c);
            }
        }

        return letters.isEmpty();
    }
}
