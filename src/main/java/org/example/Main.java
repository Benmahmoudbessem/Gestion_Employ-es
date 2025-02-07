package org.example;

import org.example.controller.EmployeeController;
import org.example.model.EmployeeDAO;
import org.example.view.EmployeeView;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO model = new EmployeeDAO();
        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(model, view);

        controller.start(); // Démarrer l'application
    }
}
