package trie;

import java.util.ArrayList;
import java.util.List;


class Trie {
    Trie[] next = new Trie[26];
    int wordIndex =-1;
}
public class WordSearchII212 {
    private static Trie trie = new Trie();
    private static int m, n;
    private  static  char[][] board;
    private static String[] words;

    private static List<String> result = new ArrayList<>();

    public static List<String> findWords(char[][] board, String[] words) {

        m = board.length;
        n= board[0].length;
        WordSearchII212.board = board;
        WordSearchII212.words = words;

        for (int i=0; i < words.length; i++){
            addWord(words[i],i);
        }

        for (int i=0; i< m; i++){
            for (int j=0; j < n; j++){
                dfs(i,j, trie);
            }
        }

        return result;


    }

    public static void dfs(int r, int c, Trie node){

        if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] == '.') return;

        int index = board[r][c] -'a';

        if (node.next[index] == null) return;

        node = node.next[index];

        if (node.wordIndex != -1){
            result.add(words[node.wordIndex]);
            node.wordIndex = -1;
        }

        char o = board[r][c];
        board[r][c] = '.';

        dfs(r+1, c, node); dfs(r-1, c, node);
        dfs(r, c+1, node); dfs(r, c-1, node);

        board[r][c] = o;

    }

    private static void addWord(String word, int wordIndex){
        Trie node = trie;

        for (char c: word.toCharArray()){
            int index = c -'a';
            if (node.next[index] == null){
                node.next[index] = new Trie();
            }
            node = node.next[index];
        }

        node.wordIndex = wordIndex;

    }

    public static void main(String[] args) {
       char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
       String[] words = {"oath","pea","eat","rain"};

        System.out.println(findWords(board,words));
    }
}
