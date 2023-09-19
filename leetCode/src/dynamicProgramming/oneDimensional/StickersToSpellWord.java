package dynamicProgramming.oneDimensional;

import java.util.ArrayDeque;
import java.util.Deque;

public class StickersToSpellWord {
    public int minStickers(String[] stickers, String target) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int min = 0, n = target.length(), prevState, nxtState, finalState = (1<<n) -1, id;
        boolean[] visited = new boolean[1<<n];
        visited[0] = true;

        while (!queue.isEmpty()){
            for (int p= queue.size(); p>0; p--){
                prevState = queue.poll();
                if (prevState == finalState)
                    return min;

                for (String sticker : stickers){
                    nxtState = prevState;
                    int[] count = new int[26];

                    for (int i=0;i<sticker.length();i++)
                        count[sticker.charAt(i)-'a']++;

                    for (int i=0; i< n;i++){
                        id = target.charAt(i) - 'a';
                        if ((nxtState & (1 << i)) == 0 && count[id] >0){
                            count[id]--;
                            nxtState |= (1 << i);
                        }
                        if (!visited[nxtState]){
                            visited[nxtState] = true;
                            queue.offer(nxtState);
                        }

                    }
                }
            }
            min++;
        }
        return -1;
    }

    public static void main(String[] args) {
        StickersToSpellWord prog = new StickersToSpellWord();
        System.out.println(prog.minStickers(new String[]{"with","example","science"}, "thehat"));
    }
}
