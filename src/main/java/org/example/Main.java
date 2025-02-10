package org.example;

import org.example.controller.EmployeeController;
import org.example.model.EmployeeDAO;
import org.example.view.EmployeeView;
import org.example.model.UserDAO;
import org.example.view.LoginFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Fenêtre de connexion
        LoginFrame loginFrame = new LoginFrame(null);

        // Vérifier l'authentification
        if (loginFrame.isAuthenticated()) {
            UserDAO userDAO = new UserDAO();
            if (userDAO.authenticate(loginFrame.getUsername(), loginFrame.getPassword())) {
                JOptionPane.showMessageDialog(null, "Connexion réussie bienvenue Bessem&Wajdi !");

                // Démarrer l'application principale
                EmployeeDAO model = new EmployeeDAO();
                EmployeeView view = new EmployeeView();
                EmployeeController controller = new EmployeeController(model, view);

                controller.start();
            } else {
                JOptionPane.showMessageDialog(null, "Identifiants incorrects", "Erreur", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        } else {
            System.exit(0); // Quitter si l'utilisateur ferme la fenêtre sans se connecter
        }
    }
}
