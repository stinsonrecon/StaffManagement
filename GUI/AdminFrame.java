package GUI;

import javax.swing.*;

public class AdminFrame extends JFrame {
    private JPanel loginWindow;
    private JButton editEmployeeList;

    public AdminFrame() {
        setVisible(true);
        setTitle("Welcome!");
        setSize(300, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.loginWindow = new JPanel();
        this.editEmployeeList = new JButton("Edit employee list");

        add(loginWindow);
        loginWindow.add(editEmployeeList);

        editEmployeeList.setBounds(10,50,200,20);
    }
}
