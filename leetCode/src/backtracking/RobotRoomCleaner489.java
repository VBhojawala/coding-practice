package backtracking;


import java.util.HashSet;
import java.util.Set;

interface Robot {
    public boolean move();
    public void turnLeft();
    public void turnRight();
    public void clean();
}
public class RobotRoomCleaner489 {
    private Robot robot;
    private Set<Pair<Integer, Integer>> visited = new HashSet<>();
    int[][] dir = new int[][] {{-1,0},{0,1}, {1,0},{0,-1}};

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        dfs(0,0,0);
    }

    private void dfs(int row, int col, int d){
        visited.add(new Pair<>(row, col));
        robot.clean();

        for (int i=0; i<4; i++){
            int newD = (d + i) % 4;
            int newRow = row + dir[newD][0];
            int newCol = col + dir[newD][1];

            if (!visited.contains(new Pair<>(newRow, newCol)) && robot.move()){
                dfs(newRow, newCol, newD);
                goBack();
            }
            robot.turnRight();
        }

    }

    public void goBack(){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
