package GUI;

import DAO.AccountDAO;
import DAO.CanBoDAO;
import Model.CanBo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class CreateAccountFrame extends JFrame {
    private JPanel loginWindow;
    private JLabel ten;
    private JLabel gioiTinh;
    private JLabel tuoi;
    private JLabel diaChi;
    private JLabel SDT;
    private JLabel email;
    private JLabel chucVu;
    private JTextField tenText;
    private JTextField tuoiText;
    private JTextField gioiTinhText;
    private JTextField diaChiText;
    private JTextField SDTText;
    private JTextField emailText;
    private JComboBox chucVuComboBox;
    private JLabel userNameLabel;
    private JLabel passWordLabel;
    private JTextField userNameTextField;
    private JPasswordField passWordTextField;
    private JLabel INFO;
    private JLabel ACC;
    private JLabel warning;
    private JLabel warning2;
    private JLabel dot;
    private JLabel dot2;
    private JLabel dot3;
    private JLabel dot4;
    private JLabel dot5;
    private JLabel dot6;
    private JLabel dot7;
    private JLabel dot8;
    private JLabel detail;
    private JTextField detailText;
    private JButton create;
    private final LoginFrame login = new LoginFrame();
    private final CanBoDAO canBoDAO = new CanBoDAO();
    private final AccountDAO accountDAO = new AccountDAO();

    public CreateAccountFrame() {
        setVisible(true);
        setTitle("General information");
        setSize(600, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String item[] = {"Công nhân", "Kỹ sư", "Nhân viên"};

        this.loginWindow = new JPanel();
        this.ten = new JLabel("Tên");
        this.tuoi = new JLabel("Tuổi");
        this.gioiTinh = new JLabel("Giới Tính");
        this.diaChi = new JLabel(" Địa Chỉ");
        this.SDT = new JLabel("SDT");
        this.email = new JLabel("Email");
        this.tenText = new JTextField();
        this.tuoiText = new JTextField();
        this.gioiTinhText = new JTextField();
        this.diaChiText = new JTextField();
        this.SDTText = new JTextField();
        this.emailText = new JTextField();
        this.chucVu = new JLabel("Chức Vụ");
        //this.viTriText = new JTextField();
        this.chucVuComboBox = new JComboBox(item);
        this.userNameLabel = new JLabel("Username");
        this.passWordLabel = new JLabel("Password");
        this.userNameTextField = new JTextField();
        this.passWordTextField = new JPasswordField();
        this.INFO = new JLabel("THÔNG TIN CÁ NHÂN");
        this.ACC = new JLabel("TÀI KHOẢN");
        this.warning = new JLabel("( Mật khẩu bao gồm ít nhất 3 chữ số, 2 chữ hoa, chữ thường ");
        this.warning2 = new JLabel(" và ít nhất 1 ký tự đặc biệt )");
        this.dot = new JLabel("( * ) bắt buộc điền");
        this.dot2 = new JLabel("( * )");
        this.dot3 = new JLabel("( * )");
        this.dot4 = new JLabel("( * )");
        this.dot5 = new JLabel("( * )");
        this.dot6 = new JLabel("( * )");
        this.dot7 = new JLabel("( * )");
        this.dot8 = new JLabel("( * )");
        this.detail = new JLabel();
        this.detailText = new JTextField();
        this.create = new JButton("Create");

        chucVuComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String chucVu = (String) chucVuComboBox.getSelectedItem();
                switch (chucVu){
                    case "Công nhân":
                        detail.setText("Cấp bậc");
                        break;
                    case "Kỹ sư":
                        detail.setText("Ngành đào tạo");
                        break;
                    case "Nhân viên":
                        detail.setText("Công việc");
                        break;
                    default:
                        break;
                }
            }
        });

        loginWindow.setLayout(null);
        loginWindow.add(ten);
        loginWindow.add(tuoi);
        loginWindow.add(gioiTinh);
        loginWindow.add(diaChi);
        loginWindow.add(SDT);
        loginWindow.add(email);
        loginWindow.add(tenText);
        loginWindow.add(tuoiText);
        loginWindow.add(gioiTinhText);
        loginWindow.add(diaChiText);
        loginWindow.add(SDTText);
        loginWindow.add(emailText);
        loginWindow.add(chucVu);
        loginWindow.add(chucVuComboBox);
        loginWindow.add(userNameLabel);
        loginWindow.add(passWordLabel);
        loginWindow.add(userNameTextField);
        loginWindow.add(passWordTextField);
        loginWindow.add(INFO);
        loginWindow.add(ACC);
        loginWindow.add(warning);
        loginWindow.add(warning2);
        loginWindow.add(dot);
        loginWindow.add(dot2);
        loginWindow.add(dot3);
        loginWindow.add(dot4);
        loginWindow.add(dot5);
        loginWindow.add(dot6);
        loginWindow.add(dot7);
        loginWindow.add(dot8);
        loginWindow.add(detail);
        loginWindow.add(detailText);
        loginWindow.add(create);

        INFO.setBounds(0, 50, 200, 20);
        ten.setBounds(71, 80, 30, 20);
        gioiTinh.setBounds(37, 110, 60, 20);
        tuoi.setBounds(67, 140, 50, 20);
        diaChi.setBounds(45, 170, 60, 20);
        SDT.setBounds(69, 200, 50, 20);
        email.setBounds(60, 230, 50, 20);
        chucVu.setBounds(42, 260, 60, 20);
        detail.setBounds(32,290,100,20);

        ACC.setBounds(0, 350, 200, 20);
        userNameLabel.setBounds(30, 380, 70, 20);
        passWordLabel.setBounds(33, 410, 60, 20);

        tenText.setBounds(120,80,300,20);
        gioiTinhText.setBounds(120,110,300,20);
        tuoiText.setBounds(120,140,300,20);
        diaChiText.setBounds(120,170,300,20);
        SDTText.setBounds(120,200,300,20);
        emailText.setBounds(120,230,300,20);
        chucVuComboBox.setBounds(120,260,300,20);
        detailText.setBounds(120,290,300,20);

        userNameTextField.setBounds(120,380,300,20);
        passWordTextField.setBounds(120,410,300,20);
        warning.setBounds(33,435,700,20);
        warning2.setBounds(33,458,200,20);

        dot.setBounds(430,80,150,20);
        dot2.setBounds(430,110,30,20);
        dot3.setBounds(430,140,30,20);
        dot4.setBounds(430,170,30,20);
        dot5.setBounds(430,200,30,20);
        dot6.setBounds(430,230,30,20);
        dot7.setBounds(430,350,30,20);
        dot8.setBounds(430,380,30,20);

        create.setBounds(120,493,80,20);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String crTen=CreateAccountFrame.this.getTenText().getText();
                    String crGioiTinh=CreateAccountFrame.this.getGioiTinhText().getText();
                    int crTuoi=Integer.parseInt(CreateAccountFrame.this.getTuoiText().getText());
                    String crDiaChi=CreateAccountFrame.this.getDiaChiText().getText();
                    String crSDT=CreateAccountFrame.this.getSDTText().getText();
                    String crEmail=CreateAccountFrame.this.getEmailText().getText();

                    String crChuThic=CreateAccountFrame.this.getDetailText().getText();

                    String crUsername=CreateAccountFrame.this.getUserNameTextField().getText();
                    String crPassword=CreateAccountFrame.this.getPassWordTextField().getText();
                    CanBo canBo= canBoDAO.Insert(crTen,crGioiTinh,crTuoi,crDiaChi,crSDT,crEmail);
                    String selectCV=(String)CreateAccountFrame.this.getChucVuComboBox().getSelectedItem();
                    switch(selectCV){
                        case"Công nhân":
                            String result=accountDAO.CreateAccCN(crUsername,crPassword,canBo,crChuThic);
                            JOptionPane.showMessageDialog(CreateAccountFrame.this,result);
                            Thread.sleep(1000);
                            CreateAccountFrame.this.setVisible(false);
                            login.setVisible(true);
                            break;
                        case"Kỹ sư":
                            String result1=accountDAO.CreateAccKS(crUsername,crPassword,canBo,crChuThic);
                            JOptionPane.showMessageDialog(CreateAccountFrame.this,result1);
                            Thread.sleep(1000);
                            CreateAccountFrame.this.setVisible(false);
                            login.setVisible(true);
                            break;
                        case"Nhân viên":
                            String result2=accountDAO.CreateAccNV(crUsername,crPassword,canBo,crChuThic);
                            JOptionPane.showMessageDialog(CreateAccountFrame.this,result2);
                            Thread.sleep(1000);
                            CreateAccountFrame.this.setVisible(false);
                            login.setVisible(true);
                            break;
                        default:
                            break;
                    }
                }catch(IOException i ){
                    i.printStackTrace();
                } catch (InterruptedException ioException){
                    ioException.printStackTrace();
                }
            }
        });

        add(loginWindow);
    }

    public JTextField getTenText() {
        return tenText;
    }

    public void setTenText(JTextField tenText) {
        this.tenText = tenText;
    }

    public JTextField getTuoiText() {
        return tuoiText;
    }

    public void setTuoiText(JTextField tuoiText) {
        this.tuoiText = tuoiText;
    }

    public JTextField getGioiTinhText() {
        return gioiTinhText;
    }

    public void setGioiTinhText(JTextField gioiTinhText) {
        this.gioiTinhText = gioiTinhText;
    }

    public JTextField getDiaChiText() {
        return diaChiText;
    }

    public void setDiaChiText(JTextField diaChiText) {
        this.diaChiText = diaChiText;
    }

    public JTextField getSDTText() {
        return SDTText;
    }

    public void setSDTText(JTextField SDTText) {
        this.SDTText = SDTText;
    }

    public JTextField getEmailText() {
        return emailText;
    }

    public void setEmailText(JTextField emailText) {
        this.emailText = emailText;
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

    public JButton getCreate() {
        return create;
    }

    public void setCreate(JButton create) {
        this.create = create;
    }

    public JTextField getDetailText() {
        return detailText;
    }

    public void setDetailText(JTextField detailText) {
        this.detailText = detailText;
    }

    public JLabel getDetail() {
        return detail;
    }

    public void setDetail(JLabel detail) {
        this.detail = detail;
    }

    public JComboBox getChucVuComboBox() {
        return chucVuComboBox;
    }

    public void setChucVuComboBox(JComboBox chucVuComboBox) {
        this.chucVuComboBox = chucVuComboBox;
    }


}
