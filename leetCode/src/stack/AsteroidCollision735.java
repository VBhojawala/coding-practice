package stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class AsteroidCollision735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids){
            if (asteroid > 0)
                stack.push(asteroid);
            else {
                while (!stack.isEmpty() && stack.peek() > 0 &&  stack.peek() < Math.abs(asteroid)){
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroid))
                    stack.pop();
                else if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(asteroid);
            }
        }

        return stack.stream().mapToInt(Integer::valueOf).toArray();

    }

    public static void main(String[] args) {
        AsteroidCollision735 prog = new AsteroidCollision735();
        Arrays.stream(prog.asteroidCollision(new int[]{5,10,-5})).forEach(System.out::println);
        System.out.println();
        Arrays.stream(prog.asteroidCollision(new int[]{-2,-1,1,2})).forEach(System.out::println);
        System.out.println();
        Arrays.stream(prog.asteroidCollision(new int[]{10,2,-5})).forEach(System.out::println);
    }
}
