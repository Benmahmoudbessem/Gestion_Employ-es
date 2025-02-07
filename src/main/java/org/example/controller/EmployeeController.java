package org.example.controller;

import org.example.model.Employee;
import org.example.model.EmployeeDAO;
import org.example.view.EmployeeView;

import javax.swing.*;

public class EmployeeController {
    private final EmployeeDAO model;
    private final EmployeeView view;

    public EmployeeController(EmployeeDAO model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    // ✅ Méthode pour démarrer l'application et attacher les écouteurs
    public void start() {
        view.addEmployeeListener(e -> addEmployee());
        view.deleteEmployeeListener(e -> deleteEmployee());
        view.showEmployeesListener(e -> updateView());
        view.addUpdateEmployeeListener(e -> updateEmployee());
    }

    // ✅ Méthode pour ajouter un employé
    private void addEmployee() {
        try {
            Employee emp = view.getEmployeeDetails();
            model.addEmployee(emp);
            JOptionPane.showMessageDialog(view, "Employé ajouté avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
            updateView();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Veuillez entrer un salaire valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erreur lors de l'ajout : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ✅ Méthode pour supprimer un employé
    private void deleteEmployee() {
        try {
            int id = view.getSelectedEmployeeId();
            model.deleteEmployee(id);
            JOptionPane.showMessageDialog(view, "Employé supprimé avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
            updateView();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Veuillez entrer un ID valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erreur lors de la suppression : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ✅ Méthode pour mettre à jour un employé
    private void updateEmployee() {
        try {
            int id = view.getUpdateEmployeeId(); // Récupérer l'ID de l'employé à mettre à jour
            String name = view.getEmployeeDetails().getName();
            String position = view.getEmployeeDetails().getPosition();
            double salary = view.getEmployeeDetails().getSalary();

            if (name.isEmpty() || position.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Veuillez remplir tous les champs avant la mise à jour.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Créer un nouvel objet Employee avec les nouvelles informations
            Employee updatedEmployee = new Employee(id, name, position, salary);
            model.updateEmployee(updatedEmployee);

            JOptionPane.showMessageDialog(view, "Employé mis à jour avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
            updateView();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Veuillez entrer un salaire valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erreur lors de la mise à jour : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ✅ Méthode pour actualiser la vue
    private void updateView() {
        view.displayEmployees(model.getAllEmployees());
    }
}
