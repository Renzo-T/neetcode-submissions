class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int l = 0;

        CleaningMap<Character> map = new CleaningMap<>();
        for (Character c : s1.toCharArray()) {
            map.increment(c);
        }

        for (int r = 0; r < s2.length(); r++) {
            map.decrement(s2.charAt(r));
            if (r - l + 1 > s1.length()) {
                map.increment(s2.charAt(l++));
            }
            if (map.size() == 0) {
                return true;
            }
        }
        return false;
    }

    class CleaningMap<K> {
        Map<K, Integer> map;
    
        public CleaningMap() {
            map = new HashMap<>();
        }

        private void cleanIfZero(K key) {
            Integer value = map.get(key);
            if (value != null && value == 0) {
                map.remove(key);
            }
        }

        public void increment(K key) {
            map.put(key, map.getOrDefault(key, 0) + 1);
            cleanIfZero(key);
        }

        public void decrement(K key) {
            map.put(key, map.getOrDefault(key, 0) - 1);
            cleanIfZero(key);
        }

        public int size() {
            return map.size();
        }
    }
}
