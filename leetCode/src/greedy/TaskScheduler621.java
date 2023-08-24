package greedy;

public class TaskScheduler621 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max=0;

        for (char c : tasks)
            max =Math.max(max,++count[c-'A']);

        int maxCount=0;

        for (int c : count){
            if (c == max)
                maxCount++;
        }

        return Math.max(tasks.length, (max -1) * (n+1) + maxCount);
    }

    public static void main(String[] args) {
        TaskScheduler621 prog = new TaskScheduler621();
        System.out.println(prog.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        System.out.println(prog.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }
}
