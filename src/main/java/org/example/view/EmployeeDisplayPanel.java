package org.example.view;

import org.example.model.Employee;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.List;

public class EmployeeDisplayPanel extends JPanel {
    private JTextPane displayArea;  // Remplacer JTextArea par JTextPane

    public EmployeeDisplayPanel() {
        setLayout(new BorderLayout());
        displayArea = new JTextPane();
        displayArea.setEditable(false);
        displayArea.setContentType("text/html");  // Permet l'utilisation de HTML pour les icônes
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
    }

    public void displayEmployees(List<Employee> employees) {
        StringBuilder htmlContent = new StringBuilder("<html><body>");
        for (Employee emp : employees) {
            // Ajouter une icône avant chaque employé
            htmlContent.append("<p><img src='file:src/main/resources/name.png' width='20' height='20' /> ");  // Ajouter une icône
            htmlContent.append("ID: ").append(emp.getId()).append("<br>");
            htmlContent.append("Nom: ").append(emp.getName()).append("<br>");
            htmlContent.append("Poste: ").append(emp.getPosition()).append("<br>");
            htmlContent.append("Salaire: ").append(emp.getSalary()).append("<br>");
            htmlContent.append("-----------------------------------------</p>");
        }
        htmlContent.append("</body></html>");
        displayArea.setText(htmlContent.toString());
    }
}
