package graph.general;

import java.util.*;

public class CourseSchedule207 {

    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0; i< numCourses; i++)
            graph.put(i, new ArrayList<>());

        for (int[] prerequisite : prerequisites)
            graph.get(prerequisite[0]).add(prerequisite[1]);

        for (int i=0; i< numCourses; i++) {
            if (!dfs(i))
                return false;
        }
        return true;
    }

    private boolean dfs(int course){

        if (visited.contains(course))
            return false;
        if (graph.get(course).isEmpty())
            return true;

        visited.add(course);

        for(int prerequisite : graph.get(course)){
            if (!dfs(prerequisite)) return false;
        }

        visited.remove(course);
        graph.get(course).clear();

        return true;

    }

    public static void main(String[] args) {
        CourseSchedule207 prog = new CourseSchedule207();
        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};
        System.out.println(prog.canFinish(5, prerequisites));

    }
}
