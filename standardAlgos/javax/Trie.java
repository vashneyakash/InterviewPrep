package javax;

import javax.swing.tree.TreeNode;

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
            if (node.getChildren()[convertCharToTrieIndex(key.charAt(index))] != null) {
                node = node.getChildren()[convertCharToTrieIndex(key.charAt(index))];
            } else {
                node.getChildren()[convertCharToTrieIndex(key.charAt(index))] = new TrieNode(index == (key.length() - 1));
            }
        }
    }

    private int convertCharToTrieIndex(char ch) {
        if (ch == ' ') {
            return 26;
        } else {
            return ch - 'a';
        }
    }

    public boolean query(String key) {
        TrieNode node = root;
        for (int index = 0; index < key.length(); index++) {
            if (node.getChildren()[convertCharToTrieIndex(key.charAt(index))] != null) {
                node = node.getChildren()[convertCharToTrieIndex(key.charAt(index))];
            } else {
                return false;
            }
        }
        return node.isEndNode();
    }

    public void remove(String key) {
        TrieNode node = root;
        for (int index = 0; index < key.length(); index++) {
            if (node.getChildren()[convertCharToTrieIndex(key.charAt(index))] != null) {
                node = node.getChildren()[convertCharToTrieIndex(key.charAt(index))];
            } else {
                return;
            }
        }
        if (node.isEndNode()) {

        }
    }
}
