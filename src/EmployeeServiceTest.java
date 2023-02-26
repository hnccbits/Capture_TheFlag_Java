import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @Before
    public void setup(){
        employeeService = new EmployeeServiceImpl();
    }

    @After
    public void tearDown(){
        employeeService = null;
    }

    @Test
    public void insertEmployee() {
        Employee employee = new Employee(1, "Nipun Kumar", "Student", (short) 10, (short) 20);
        boolean inserted = employeeService.insertEmployee(employee);
        boolean inserted2 = employeeService.insertEmployee(employee);
        assertEquals(1,employeeService.getAllEmployee().size());
        assertTrue(inserted);
        assertFalse(inserted2);
        Employee insertedEmployee = employeeService.getEmployeeWithId(employee.getEmployeeId());
        assertEquals(insertedEmployee.getEmployeeId(),employee.getEmployeeId());
    }

    @Test
    public void deleteEmployee() {
        Employee employee = new Employee(1, "Nipun Kumar", "Student", (short) 10, (short) 20);
        employeeService.insertEmployee(employee);
        boolean deleted = employeeService.deleteEmployee(1);
        assertTrue(deleted);
        boolean deleted2 = employeeService.deleteEmployee(2);
        assertFalse(deleted2);
        assertEquals(0,employeeService.getAllEmployee().size());
    }

    @Test
    public void getEmployeeWithIdTest(){
        Employee employee = new Employee(1, "Nipun Kumar", "Student", (short) 10, (short) 20);
        employeeService.insertEmployee(employee);
        Employee foundedEmployee = employeeService.getEmployeeWithId(1);
        Employee foundedEmployee2 = employeeService.getEmployeeWithId(2);
        assertEquals(foundedEmployee.getEmployeeName(),"Nipun Kumar");
        assertNull(foundedEmployee2);
    }
}