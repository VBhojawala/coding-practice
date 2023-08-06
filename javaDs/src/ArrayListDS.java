import java.util.ArrayList;
import java.util.List;

public class ArrayListDS {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();

        integerList.add(5);
        integerList.add(9);
        integerList.add(7);
        integerList.add(10);

        integerList.contains(5);

        integerList.stream().forEach(System.out::println);

    }
}
