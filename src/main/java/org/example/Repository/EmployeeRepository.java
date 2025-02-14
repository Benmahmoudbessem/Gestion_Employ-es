package org.example.Repository;



import org.example.model.Employee;
import java.util.List;

public interface EmployeeRepository {
    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    void deleteEmployee(int id);
    void updateEmployee(Employee employee);
}
