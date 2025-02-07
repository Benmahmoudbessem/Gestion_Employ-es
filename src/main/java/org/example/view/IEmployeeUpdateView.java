package org.example.view;

import java.awt.event.ActionListener;

public interface IEmployeeUpdateView {
    void addUpdateEmployeeListener(ActionListener listener);
    int getUpdateEmployeeId();
}
