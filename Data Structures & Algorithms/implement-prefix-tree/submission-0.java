class PrefixTree {
    private class TrieNode {
        public Map<Character, TrieNode> node;
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
            if (!curr.node.containsKey(c)) {
                curr.node.put(c, new TrieNode());
            }
            curr = curr.node.get(c);
        }
        curr.node.put(' ', null);
    }

    public boolean search(String word) {
        TrieNode curr = head;
        for (Character c : word.toCharArray()) {
            if (!curr.node.containsKey(c)) {
                return false;
            }
            curr = curr.node.get(c);
        }
        return curr.node.containsKey(' ');
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
