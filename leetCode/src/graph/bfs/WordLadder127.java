package graph.bfs;

import java.util.*;

public class WordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int count =0;

        while (!queue.isEmpty()){
            count++;
            for (int l=queue.size(); l>0; l--){
                String curr = queue.poll();
                for (int i=0; i< curr.length();i++){
                    char[] chars = curr.toCharArray();
                    for (char k='a'; k <= 'z';k++){
                        chars[i]= k;
                        String p = new String(chars);
                        if(!wordSet.contains(p))
                            continue;
                        if (p.equals(endWord))
                            return ++count;
                        queue.offer(p);
                        wordSet.remove(p);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList= Arrays.asList("hot","dot","dog","lot","log","cog");

        WordLadder127 prog = new WordLadder127();
        System.out.println("Shortest Transformation : " + prog.ladderLength(beginWord, endWord, wordList));
    }
}
