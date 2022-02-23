package javax;

public class Trie {
    private static final int ALPHABET_COUNT = 26;

    public static class TrieNode {
        private final boolean isEndNode;
        private final TrieNode[] children;

        public TrieNode(boolean isEndNode) {
            this.isEndNode = isEndNode;
            this.children = new TrieNode[ALPHABET_COUNT];
        }

        public boolean isEndNode() {
            return isEndNode;
        }

        public TrieNode[] getChildren() {
            return children;
        }
    }

    private static TrieNode root = new TrieNode(false);

    public void insert(String key) {
        TrieNode node = root;
        for (int index = 0; index < key.length(); index++) {
            if (node.getChildren()[index] != null) {
                node = node.getChildren()[index];
            } else {
                node.getChildren()[index] = new TrieNode(index == (key.length() - 1));
            }
        }
    }

    public boolean query(String key) {
        TrieNode node = root;
        for (int index = 0; index < key.length(); index++) {
            if (node.getChildren()[index] != null) {
                node = node.getChildren()[index];
            } else {
                return false;
            }
        }
        return node.isEndNode();
    }
}
