package trie;

public class Trie208 {

    private Trie208[] next;
    private boolean isEnd;

    public Trie208() {
        next = new Trie208[26];
    }

    public void insert(String word) {
        Trie208 node = this;

        for (char c : word.toCharArray()){
            int index = c - 'a';
            if (node.next[index] == null){
                node.next[index] = new Trie208();
            }
            node = node.next[index];
        }
        node.isEnd = true;

    }

    public boolean search(String word) {
        Trie208 node =searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) !=null;
    }

    private Trie208 searchPrefix(String s ){
        Trie208 node = this;
        for (char c : s.toCharArray()){
            int index = c -'a';
            if (node.next[index] == null)
                return null;
            node = node.next[index];
        }
        return node;
    }
}
