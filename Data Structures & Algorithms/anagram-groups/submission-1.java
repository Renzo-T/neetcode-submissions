class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            String anagramString = getAnagramString(str);
            anagrams.putIfAbsent(anagramString, new ArrayList<>());
            anagrams.get(anagramString).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }

    private String getAnagramString (String str) {
        int[] chars = new int[26];
        for (char c : str.toCharArray()) {
            chars[c - 'a']++;
        }
        
        return Arrays.toString(chars);
    }
}
