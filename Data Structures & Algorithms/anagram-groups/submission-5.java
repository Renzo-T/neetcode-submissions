class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            String encoding = encodeString(str);
            anagramMap.computeIfAbsent(encoding, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList(anagramMap.values());
    }

    private String encodeString(String str) {
        int[] charMap = new int[26];
        for (char c : str.toCharArray()) {
            charMap[c-'a']++;
        }
        
        return Arrays.toString(charMap);
        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < 26; i++) {
        //     if(charMap[i] > 0) {
        //         sb.append(charMap[i]).append((char)(i+'a'));
        //     }
        // }

        // return sb.toString();
    }
}
