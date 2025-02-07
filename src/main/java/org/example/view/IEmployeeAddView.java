package org.example.view;

import org.example.model.Employee;

import java.awt.event.ActionListener;

public interface IEmployeeAddView {
    void addEmployeeListener(ActionListener listener);
    Employee getEmployeeDetails();
}

