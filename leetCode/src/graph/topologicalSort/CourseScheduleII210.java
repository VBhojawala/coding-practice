package graph.topologicalSort;

import java.util.*;

public class CourseScheduleII210 {

    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> cycle = new HashSet<>();
    Set<Integer> visit = new HashSet<>();
    int[] result;
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        result = new int[numCourses];
        index=0;
        for(int i=0; i< numCourses; i++)
            graph.put(i, new ArrayList<>());

        for (int[] prerequisite : prerequisites)
            graph.get(prerequisite[0]).add(prerequisite[1]);

        for (int i=0; i< numCourses; i++) {
            if (!dfs(i))
                return new int[0];
        }
        return result;

    }

    private boolean dfs(int course){

        if(cycle.contains(course))
            return false;
        if(visit.contains(course))
            return true;

        cycle.add(course);

        for(int prerequisite : graph.get(course)){
            if (!dfs(prerequisite)) return false;
        }

        cycle.remove(course);
        visit.add(course);
        result[index++] = course;
        return true;

    }

    public static void main(String[] args) {
        CourseScheduleII210 prog = new CourseScheduleII210();
        int[][] prerequisites = {{1,0}};
        int[] result = prog.findOrder(2, prerequisites);
        for (int i=0; i<result.length;i++){
            System.out.print(result[i] + "  ");
        }

    }
}
