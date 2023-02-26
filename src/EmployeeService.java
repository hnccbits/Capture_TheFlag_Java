import java.util.ArrayList;

public interface EmployeeService {

    boolean insertEmployee(Employee employee);

    boolean deleteEmployee(int id);

    Employee getEmployeeWithId(int id);

    ArrayList<Employee> getAllEmployee();
}
