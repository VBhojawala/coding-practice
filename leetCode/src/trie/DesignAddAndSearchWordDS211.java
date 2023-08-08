package trie;


public class DesignAddAndSearchWordDS211 {

    class Trie {
        public Trie[] next = new Trie[26];
        public boolean isEnd;
    }
    private Trie trie;

    public DesignAddAndSearchWordDS211(){
        trie = new Trie();
    }

    public void addWord(String word) {
        Trie node = trie;
        for (char c : word.toCharArray()){
            int index = c -'a';
            if(node.next[index] == null)
                node.next[index] = new Trie();
            node = node.next[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, trie);
    }

    private boolean search(String word, Trie node){
        for (int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';

            if (c != '.' && node.next[index] == null)
                return false;

            if (c == '.'){
                for (Trie next : node.next){
                    if(next != null && search(word.substring(i+1), next))
                        return true;
                }
                return false;

            }
            node = node.next[index];
        }
        return node.isEnd;
    }

    public static void main(String[] args) {
        DesignAddAndSearchWordDS211 wordDictionary = new DesignAddAndSearchWordDS211();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // return False
        wordDictionary.search("bad"); // return True
        wordDictionary.search(".ad"); // return True
        System.out.println(wordDictionary.search("b.."));; // return True
    }

}
