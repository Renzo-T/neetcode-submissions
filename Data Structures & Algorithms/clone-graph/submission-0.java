/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNewNode = new HashMap<>();
        return cloneGraph(node, oldToNewNode);
    }

    private Node cloneGraph(Node node, Map<Node, Node> oldToNewNode) {
        if (oldToNewNode.containsKey(node) || node == null) {
            return oldToNewNode.get(node);
        }

        Node copyNode = new Node(node.val);
        oldToNewNode.put(node, copyNode);
        copyNode.neighbors = node.neighbors.stream().map(neighbor ->
            cloneGraph(neighbor, oldToNewNode)
        ).collect(Collectors.toList());
        
        return copyNode;
    }
}