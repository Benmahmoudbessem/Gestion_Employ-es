package org.example.view;

import org.example.model.Employee;

import java.awt.event.ActionListener;
import java.util.List;

public interface IEmployeeDisplayView {

    void showEmployeesListener(ActionListener listener);
    void displayEmployees(List<Employee> employees);
}
