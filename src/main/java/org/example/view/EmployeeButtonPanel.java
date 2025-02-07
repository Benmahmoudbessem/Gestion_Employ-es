package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EmployeeButtonPanel extends JPanel {
    private JButton deleteButton = new JButton("Supprimer Employé");
    private JButton updateButton = new JButton("Mettre à jour Employé");
    private JButton showButton = new JButton("Afficher Employés");
    private JTextField deleteField = new JTextField(5);
    private JTextField updateField = new JTextField(5);

    public EmployeeButtonPanel() {
        setLayout(new GridLayout(3, 2));
        add(new JLabel("ID à supprimer:"));
        add(deleteField);
        add(deleteButton);
        add(new JLabel("ID à mettre à jour:"));
        add(updateField);
        add(updateButton);
        add(showButton);
    }

    public int getSelectedEmployeeId() {
        return Integer.parseInt(deleteField.getText());
    }

    public int getUpdateEmployeeId() {
        return Integer.parseInt(updateField.getText());
    }

    public void deleteEmployeeListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void addUpdateEmployeeListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }

    public void showEmployeesListener(ActionListener listener) {
        showButton.addActionListener(listener);
    }
}
