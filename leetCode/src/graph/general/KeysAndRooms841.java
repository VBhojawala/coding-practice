package graph.general;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms841 {
    private List<List<Integer>> rooms;
    private Set<Integer> visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms;
        visited = new HashSet<>();
        dfs(0);
        return visited.size() == rooms.size();
    }

    private void dfs(int room){
        if (visited.contains(room)) return;
        visited.add(room);
        for (int key : rooms.get(room))
            dfs(key);
    }
}
