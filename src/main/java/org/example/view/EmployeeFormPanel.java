package org.example.view;

import org.example.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EmployeeFormPanel extends JPanel {
    private JTextField nameField = new JTextField(15);
    private JTextField positionField = new JTextField(15);
    private JTextField salaryField = new JTextField(15);
    private JButton addButton = new JButton("Ajouter Employé");

    public EmployeeFormPanel() {
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Nom:"));
        add(nameField);
        add(new JLabel("Poste:"));
        add(positionField);
        add(new JLabel("Salaire:"));
        add(salaryField);
        add(addButton);
    }

    public Employee getEmployeeDetails() {
        return new Employee(0, nameField.getText(), positionField.getText(), Double.parseDouble(salaryField.getText()));
    }

    public void addEmployeeListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
}
