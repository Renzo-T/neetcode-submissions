class PrefixTree {
    private class TrieNode {
        public Map<Character, TrieNode> node;
        boolean endOfWord;
        public TrieNode() {
            this.node = new HashMap<>();
        }
    }

    TrieNode head;
    public PrefixTree() {
        head = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = head;
        for (Character c : word.toCharArray()) {
            curr.node.putIfAbsent(c, new TrieNode());
            curr = curr.node.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = head;
        for (Character c : word.toCharArray()) {
            if (!curr.node.containsKey(c)) {
                return false;
            }
            curr = curr.node.get(c);
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = head;
        for (Character c : prefix.toCharArray()) {
            if (!curr.node.containsKey(c)) {
                return false;
            }
            curr = curr.node.get(c);
        }
        return true;
    }
}
