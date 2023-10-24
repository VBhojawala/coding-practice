package hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    private Map<Integer, Employee> employeeMap;
    public int getImportance(List<Employee> employees, int id) {
        employeeMap = new HashMap<>();

        for (Employee emp : employees){
            employeeMap.put(emp.id, emp);
        }

        return dfs(id);
    }

    private int dfs(int id){
        Employee employee = employeeMap.get(id);
        int importance = employee.importance;
        for (Integer subordinate : employee.subordinates){
            importance += dfs(subordinate);
        }
        return importance;
    }
}
