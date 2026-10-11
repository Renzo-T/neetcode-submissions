class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String anagramString = getAnagramString(str);
            map.putIfAbsent(anagramString, new ArrayList<String>());
            map.get(anagramString).add(str);
        }
        
        return new ArrayList<>(map.values());
    }

    private String getAnagramString(String str) {
        int[] chars = new int[26];
        for(char c : str.toCharArray()) {
            chars[c-'a']++;
        }
        return Arrays.toString(chars);
    }
}
