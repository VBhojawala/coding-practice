package greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraights846 {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int h: hand)
            countMap.put(h, countMap.getOrDefault(h, 0)+1);

        Arrays.sort(hand);

        for (int h : hand){
            if (countMap.containsKey(h)){
                int count = countMap.get(h);
                for (int card=h; card < h+groupSize; card++){
                    if (!countMap.containsKey(card) || countMap.get(card) < count){
                        return false;
                    }
                    countMap.put(card, countMap.get(card) - count );
                    if (countMap.get(card) <= 0)
                        countMap.remove(card);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HandOfStraights846 prog = new HandOfStraights846();
        int[] hand = new int[]{1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(prog.isNStraightHand(hand, groupSize));

        hand = new int[]{1,2,3,4,5};
        groupSize = 4;
        System.out.println(prog.isNStraightHand(hand, groupSize));
    }
}
