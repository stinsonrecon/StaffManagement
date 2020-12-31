package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class EditPasswrodFrame extends JFrame {
    private JPanel account;
    private JLabel userNameLabel;
    private JLabel passWordLabel;
    private JLabel newPasswordLabel;
    private JTextField userNameTextField;
    private JPasswordField passWordTextField;
    private JPasswordField newPasswordText;
    private JLabel ACC;
    private JLabel warning;
    private JLabel warning2;
    private JLabel dot7;
    private JLabel dot8;
    private Icon icon;
    private JButton editButton;
    private JButton saveButton;

    public EditPasswrodFrame(String username){
        setVisible(true);
        setTitle("Edit account");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.dot7 = new JLabel("( * )");
        this.dot8 = new JLabel("( * )");
        this.account = new JPanel();
        this.userNameLabel = new JLabel("Username");
        this.passWordLabel = new JLabel("Old password");
        this.newPasswordLabel = new JLabel("New password");
        this.userNameTextField = new JTextField(username);
        this.passWordTextField = new JPasswordField();
        this.newPasswordText = new JPasswordField();
        this.warning = new JLabel("( Mật khẩu bao gồm ít nhất 3 chữ số, 2 chữ hoa,");
        this.warning2 = new JLabel(" chữ thường  và ít nhất 1 ký tự đặc biệt )");
        this.ACC = new JLabel("TÀI KHOẢN");
        this.editButton = new JButton();
        try {
            BufferedImage image = ImageIO.read(new File("/Users/mac/Documents/LoginTheme/src/Resource/EditIcon.png"));
            Image newImg = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            editButton.setIcon(new ImageIcon(newImg));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.saveButton = new JButton("Save");

        account.setLayout(null);
        account.add(ACC);
        account.add(userNameLabel);
        account.add(userNameTextField);
        account.add(passWordLabel);
        account.add(passWordTextField);
        account.add(newPasswordText);
        account.add(newPasswordLabel);
        account.add(warning);
        account.add(warning2);
        account.add(dot7);
        account.add(dot8);
        account.add(editButton);
        account.add(saveButton);

        userNameLabel.setBounds(35,40,70,20);
        passWordLabel.setBounds(10,70,100,20);
        newPasswordLabel.setBounds(10,100,100,20);

        userNameTextField.setBounds(110,40,200,20);
        passWordTextField.setBounds(110,70,200,20);
        newPasswordText.setBounds(110,100,200,20);

        editButton.setBounds(320,40,20,20);
        warning.setBounds(10,130,500,20);
        warning2.setBounds(10,153,400,20);
        saveButton.setBounds(110,183,70,20);

        userNameTextField.setEditable(false);

        add(account);
    }
}
