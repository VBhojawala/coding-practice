package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionSystem1268 {

    class Trie{
        Trie[] children = new Trie[26];
        List<Integer> p = new ArrayList<>();

        private void insert(String word, int pos){
            Trie node = this;
            for (int i=0;i< word.length();i++){
                int ch = word.charAt(i) - 'a';
                if (node.children[ch] == null)
                    node.children[ch] = new Trie();
                node = node.children[ch];
                if (node.p.size() < 3)
                    node.p.add(pos);
            }
        }

        private List<Integer>[] search(String word){
            Trie node = this;
            int n = word.length();
            List<Integer>[] result = new List[n];
            Arrays.setAll(result, k -> new ArrayList<>());
            for (int i=0; i< n; i++){
                int ch = word.charAt(i) - 'a';
                if (node.children[ch] == null)
                    break;
                node = node.children[ch];
                result[i] = node.p;
            }
            return result;
        }
    }


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie trie = new Trie();
        for (int i=0;i<products.length; i++)
            trie.insert(products[i], i);
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> p : trie.search(searchWord)){
            List<String> words = new ArrayList<>();
            for (int i : p)
                words.add(products[i]);
            result.add(words);
        }
        return result;
    }
}
