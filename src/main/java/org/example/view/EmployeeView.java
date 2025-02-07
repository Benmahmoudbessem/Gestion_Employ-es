package org.example.view;

import org.example.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class EmployeeView extends JFrame {
    private JTextField nameField = new JTextField(15);
    private JTextField positionField = new JTextField(15);
    private JTextField salaryField = new JTextField(15);
    private JTextField deleteField = new JTextField(5);
    private JTextField updateField = new JTextField(5);

    private JButton addButton = new JButton("Ajouter Employé");
    private JButton deleteButton = new JButton("Supprimer Employé");
    private JButton showButton = new JButton("Afficher Employés");
    private JButton updateButton = new JButton("Mettre à jour Employé");

    private JTextArea displayArea = new JTextArea(10, 40);

    public EmployeeView() {
        setTitle("Gestion des Employés");
        setSize(800, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Couleurs et mise en page
        Color backgroundColor = new Color(245, 245, 245);
        Color buttonColor = new Color(70, 130, 180);
        Color deleteColor = new Color(220, 20, 60);
        Color updateColor = new Color(255, 165, 0);
        Color textColor = Color.BLACK;
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        Font textFont = new Font("Arial", Font.PLAIN, 16);

        // Panneau principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(backgroundColor);
        setContentPane(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Ajouter les labels avec images rotatives
        addLabelAndField(panel, "Nom:", "src/main/resources/name.png", nameField, gbc, labelFont, textFont);
        addLabelAndField(panel, "Poste:", "src/main/resources/position.png", positionField, gbc, labelFont, textFont);
        addLabelAndField(panel, "Salaire:", "src/main/resources/salaire.png", salaryField, gbc, labelFont, textFont);

        // Bouton Ajouter
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setBackground(buttonColor);
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        gbc.gridx = 1;
        gbc.gridy++;
        panel.add(addButton, gbc);

        // Champ et bouton Supprimer
        addLabelAndField(panel, "ID à supprimer:", "src/main/resources/supp.png", deleteField, gbc, labelFont, textFont);
        deleteButton.setFont(new Font("Arial", Font.BOLD, 16));
        deleteButton.setBackground(deleteColor);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);
        gbc.gridx = 1;
        gbc.gridy++;
        panel.add(deleteButton, gbc);

        // Champ et bouton Mettre à jour
        addLabelAndField(panel, "ID à mettre à jour:", "src/main/resources/update.png", updateField, gbc, labelFont, textFont);
        updateButton.setFont(new Font("Arial", Font.BOLD, 16));
        updateButton.setBackground(updateColor);
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusPainted(false);
        gbc.gridx = 1;
        gbc.gridy++;
        panel.add(updateButton, gbc);

        // Bouton Afficher
        showButton.setFont(new Font("Arial", Font.BOLD, 16));
        showButton.setBackground(new Color(34, 139, 34));
        showButton.setForeground(Color.WHITE);
        showButton.setFocusPainted(false);
        gbc.gridx = 1;
        gbc.gridy++;
        panel.add(showButton, gbc);

        // Zone d'affichage stylisée
        displayArea.setFont(new Font("Arial", Font.PLAIN, 14));
        displayArea.setEditable(false);
        displayArea.setBackground(Color.WHITE);
        displayArea.setForeground(textColor);

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        gbc.gridx = 1;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(scrollPane, gbc);

        setVisible(true);
    }

    // Méthode pour ajouter un label avec une icône rotative et un champ de texte
    private void addLabelAndField(JPanel panel, String labelText, String iconPath, JTextField textField, GridBagConstraints gbc, Font labelFont, Font textFont) {
        RotatingImageLabel rotatingIcon = new RotatingImageLabel(iconPath);

        JLabel label = new JLabel(labelText);
        label.setFont(labelFont);
        label.setForeground(Color.DARK_GRAY);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(rotatingIcon, gbc);  // Ajout de l'image rotative
        gbc.gridx = 1;
        panel.add(label, gbc);

        textField.setFont(textFont);
        textField.setBackground(Color.WHITE);
        textField.setForeground(Color.BLACK);
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        gbc.gridx = 2;
        panel.add(textField, gbc);
    }

    // Récupérer les détails d'un employé
    public Employee getEmployeeDetails() {
        return new Employee(0, nameField.getText(), positionField.getText(), Double.parseDouble(salaryField.getText()));
    }

    // Récupérer l'ID pour suppression
    public int getSelectedEmployeeId() {
        return Integer.parseInt(deleteField.getText());
    }

    // Récupérer l'ID pour mise à jour
    public int getUpdateEmployeeId() {
        return Integer.parseInt(updateField.getText());
    }

    // Affichage des employés
    public void displayEmployees(List<Employee> employees) {
        displayArea.setText("");
        for (Employee emp : employees) {
            displayArea.append("ID: " + emp.getId() + "\n");
            displayArea.append("Nom: " + emp.getName() + "\n");
            displayArea.append("Poste: " + emp.getPosition() + "\n");
            displayArea.append("Salaire: " + emp.getSalary() + "\n");
            displayArea.append("-----------------------------------------\n");
        }
    }

    // Ajouter des écouteurs d'événements
    public void addEmployeeListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void deleteEmployeeListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void showEmployeesListener(ActionListener listener) {
        showButton.addActionListener(listener);
    }

    public void addUpdateEmployeeListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }
}
