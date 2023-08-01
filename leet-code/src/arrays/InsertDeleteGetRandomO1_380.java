package arrays;

import java.util.*;

public class InsertDeleteGetRandomO1_380 {

    private Map<Integer, Integer> elementsMap;
    private List<Integer> elementsList;
    private Random random;
    public InsertDeleteGetRandomO1_380() {
        elementsMap = new HashMap<>();
        elementsList = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (elementsMap.containsKey(val))
            return false;
        elementsMap.put(val, elementsList.size());
        elementsList.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!elementsMap.containsKey(val))
            return false;
        int elementIndex = elementsMap.get(val);
        elementsMap.put(elementsList.get(elementsList.size()-1), elementIndex);
        elementsList.set(elementIndex, elementsList.get(elementsList.size()-1));
        elementsList.remove(elementsList.size()-1);
        elementsMap.remove(val);
        return true;
    }

    public int getRandom() {
        return elementsList.get(random.nextInt(elementsList.size()));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandomO1_380 randomizedSet = new InsertDeleteGetRandomO1_380();

        System.out.println(randomizedSet.insert(1));;
        System.out.println(randomizedSet.remove(2));;
        System.out.println(randomizedSet.insert(2));;
        System.out.println(randomizedSet.getRandom());;
        System.out.println(randomizedSet.remove(1));;
        System.out.println(randomizedSet.insert(2));;
        System.out.println(randomizedSet.getRandom());;
    }
}
