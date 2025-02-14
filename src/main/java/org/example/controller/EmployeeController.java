package org.example.controller;

import org.example.model.Employee;
import org.example.Service.EmployeeService;
import org.example.view.EmployeeView;

import javax.swing.*;
import java.util.Optional;

public class EmployeeController {
    private final EmployeeService service;
    private final EmployeeView view;

    public EmployeeController(EmployeeService service, EmployeeView view) {
        this.service = service;
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

            // Vérifier si les champs sont vides
            if (emp.getName().isEmpty() || emp.getPosition().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            service.addEmployee(emp);
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

            // Vérifier si l'ID existe avant suppression
            Optional<Employee> employee = service.getEmployeeById(id);
            if (employee.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Employé introuvable !", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            service.deleteEmployee(id);
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
            int id = view.getUpdateEmployeeId();
            Employee emp = view.getEmployeeDetails();

            if (emp.getName().isEmpty() || emp.getPosition().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Veuillez remplir tous les champs avant la mise à jour.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Vérifier si l'ID existe avant mise à jour
            Optional<Employee> existingEmployee = service.getEmployeeById(id);
            if (existingEmployee.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Employé introuvable !", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Créer un nouvel objet Employee avec l'ID existant
            Employee updatedEmployee = new Employee(id, emp.getName(), emp.getPosition(), emp.getSalary());
            service.updateEmployee(updatedEmployee);

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
        view.displayEmployees(service.getAllEmployees());
    }
}
