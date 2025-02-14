package org.example.Service;

import org.example.model.Employee;
import org.example.Repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }


    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.getAllEmployees().stream()
                .filter(emp -> emp.getId() == id)
                .findFirst();
    }
}
