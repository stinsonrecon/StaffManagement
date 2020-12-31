package GUI;

import DAO.AccountDAO;
import Model.Account;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginFrame extends JFrame {
    private JPanel loginBackGround;
    private JLabel userNameLabel;
    private JLabel passWordLabel;
    private JTextField userNameTextField;
    private JPasswordField passWordTextField;
    private JButton loginButton;
    private JButton createAccButton;
    public boolean checkLogIn = false;

    private final AccountDAO accountDAO = new AccountDAO();

    public LoginFrame() {
        setSize(300,200);
        setTitle("Login");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.loginBackGround = new JPanel();
        loginBackGround.setLayout(null);
        this.userNameLabel = new JLabel("User name");
        this.passWordLabel = new JLabel("Password");
        this.userNameTextField = new JTextField();
        this.passWordTextField = new JPasswordField();
        this.loginButton = new JButton("Sign in");
        this.createAccButton = new JButton("Sign up");

        add(loginBackGround);
        loginBackGround.add(userNameLabel);
        loginBackGround.add(passWordLabel);
        loginBackGround.add(userNameTextField);
        loginBackGround.add(passWordTextField);
        loginBackGround.add(loginButton);
        loginBackGround.add(createAccButton);

        userNameLabel.setBounds(10,40,100,20);
        passWordLabel.setBounds(10,70,100,20);
        userNameTextField.setBounds(90,40,150,25);
        passWordTextField.setBounds(90,70,150,25);
        loginButton.setBounds(90,105,100,30);
        createAccButton.setBounds(90, 130, 100,30);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String loginUserName = userNameTextField.getText();
                    String loginPassWord = passWordTextField.getText();
                    Account loginAccount = new Account(loginUserName, loginPassWord);
                    try {
                        JSONObject account = accountDAO.Login(loginAccount);
                        String checkLogin = account.getString("result");
                        String checkAdmin = account.getString("admin");
                        String checkUsername = account.getString("username").trim();
                        int IdCanBo = Integer.parseInt(account.getString("IdCanBo").trim());
                        String IdPREFIX = account.getString("IdPREFIX").trim();

                        if (checkLogin.equals("success")) {
                            if (checkAdmin.equals("true")) {
                                //TODO: tao frame cho admin
                                JOptionPane.showMessageDialog(LoginFrame.this, "Welcome admin " + loginUserName);
                                LoginFrame.this.setVisible(false);
                                AdminFrame adminLogined = new AdminFrame();

                            } else if (checkAdmin.equals("false")) {
                                JOptionPane.showMessageDialog(LoginFrame.this, "Welcome " + loginUserName);
                                LoginFrame.this.setVisible(false);
                                GeneralFrame generalFrame = new GeneralFrame(IdPREFIX,IdCanBo,checkUsername);
                            }
                        }
                    }catch (IOException exception){
                        exception.printStackTrace();
                    }
            }
        });

        createAccButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame.this.setVisible(false);
                CreateAccountFrame createAccountFrame = new CreateAccountFrame();
            }
        });
    }



    public JTextField getUserNameTextField() {
        return userNameTextField;
    }

    public void setUserNameTextField(JTextField userNameTextField) {
        this.userNameTextField = userNameTextField;
    }

    public JPasswordField getPassWordTextField() {
        return passWordTextField;
    }

    public void setPassWordTextField(JPasswordField passWordTextField) {
        this.passWordTextField = passWordTextField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public boolean isCheckLogIn() {
        return checkLogIn;
    }

    public void setCheckLogIn(boolean checkLogIn) {
        this.checkLogIn = checkLogIn;
    }

    public JButton getCreateAccButton() {
        return createAccButton;
    }

    public void setCreateAccButton(JButton createAccButton) {
        this.createAccButton = createAccButton;
    }
}
