import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService {

    private final ArrayList<Employee> employees = new ArrayList<>();

    @Override
    public Employee getEmployeeWithId(int id) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == id) {
                return employee;
            }
        }
        return null;
    }

    private boolean isEmployeePresent(int id) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        try {
            if (isEmployeePresent(employee.getEmployeeId())) return false;
            employees.remove(employee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId() == id) {
                employees.add(employees.get(i));
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Employee> getAllEmployee() {
        return employees;
    }
}
