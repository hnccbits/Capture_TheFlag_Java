public class Employee {

    private int employeeId;
    private String employeeName;
    private String employeeDesignation;
    private short experience;
    private short age;

    public Employee() {
    }

    public Employee(int employeeId,  String employeeName, String employeeDesignation, short experience, short age) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDesignation = employeeDesignation;
        this.experience = experience;
        this.age = age;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }

    public short getExperience() {
        return experience;
    }

    public void setExperience(short experience) {
        this.experience = experience;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + employeeId + ", Name: " + employeeName + ", Designation: " + employeeDesignation + ", Experience: " + experience
                + ", Age: " + age;
    }
}
