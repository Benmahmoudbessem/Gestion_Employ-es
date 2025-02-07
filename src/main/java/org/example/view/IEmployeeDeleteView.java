package org.example.view;

import java.awt.event.ActionListener;

public interface IEmployeeDeleteView {
    void deleteEmployeeListener(ActionListener listener);
    int getSelectedEmployeeId();
}
