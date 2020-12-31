package GUI;

import DAO.CanBoDAO;
import DAO.CongNhanDAO;
import DAO.KySuDAO;
import DAO.NhanVienDAO;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EditInforFrame extends JFrame {
    private JPanel loginWindow;
    private JLabel ten;
    private JLabel gioiTinh;
    private JLabel tuoi;
    private JLabel diaChi;
    private JLabel SDT;
    private JLabel email;
    private JLabel viTri;
    private JTextField tenText;
    private JTextField tuoiText;
    private JTextField gioiTinhText;
    private JTextField diaChiText;
    private JTextField SDTText;
    private JTextField emailText;
    private JTextField viTriText;
    private JLabel INFO;
    private JLabel dot;
    private JLabel dot2;
    private JLabel dot3;
    private JLabel dot4;
    private JLabel dot5;
    private JLabel dot6;
    private JLabel detail;
    private JTextField detailText;
    private JButton edit;
    private JButton yesButt;
    private JButton noButt;
    private JButton logOutButt;
    private final NhanVienDAO nhanVienDAO = new NhanVienDAO();
    private final CongNhanDAO congNhanDao = new CongNhanDAO();
    private final KySuDAO kySuDao = new KySuDAO();
    private final CanBoDAO canBoDAO = new CanBoDAO();

    public EditInforFrame(String IdPREFIX, int IdCanBo) throws IOException {
        setVisible(true);
        setTitle("Welcome!");
        setSize(600, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        this.viTri = new JLabel("Chức Vụ");
        this.viTriText = new JTextField();
        this.INFO = new JLabel("THÔNG TIN CÁ NHÂN");
        this.dot = new JLabel("( * ) bắt buộc điền");
        this.dot2 = new JLabel("( * )");
        this.dot3 = new JLabel("( * )");
        this.dot4 = new JLabel("( * )");
        this.dot5 = new JLabel("( * )");
        this.dot6 = new JLabel("( * )");
        this.detail = new JLabel("Chú thích");
        this.detailText = new JTextField();
        this.edit = new JButton("Edit");
        this.yesButt = new JButton();
        this.noButt = new JButton();
        this.logOutButt = new JButton();

        switch (IdPREFIX) {
            case "NV":
                JSONObject nhanVien = nhanVienDAO.GetById(IdCanBo);
                this.getTenText().setText(nhanVien.getString("ten"));
                this.getGioiTinhText().setText(nhanVien.getString("gioiTinh"));
                this.getTuoiText().setText(String.valueOf(nhanVien.getInt("tuoi")));
                this.getDiaChiText().setText(nhanVien.getString("diaChi"));
                this.getSDTText().setText(nhanVien.getString("SDT"));
                this.getEmailText().setText(nhanVien.getString("email"));
                this.getViTriText().setText("Nhan Vien");
                this.getDetailText().setText(nhanVien.getString("congViec"));
                break;
            case "KS":
                JSONObject kySu = kySuDao.GetById(IdCanBo);
                this.getTenText().setText(kySu.getString("ten"));
                this.getGioiTinhText().setText(kySu.getString("gioiTinh"));
                this.getTuoiText().setText(String.valueOf(kySu.getInt("tuoi")));
                this.getDiaChiText().setText(kySu.getString("diaChi"));
                this.getSDTText().setText(kySu.getString("SDT"));
                this.getEmailText().setText(kySu.getString("email"));
                this.getViTriText().setText("Ky Su");
                this.getDetailText().setText(kySu.getString("nganhDaoTao"));
                break;
            case "CN":
                JSONObject congNhan = congNhanDao.GetById(IdCanBo);
                this.getTenText().setText(congNhan.getString("ten"));
                this.getGioiTinhText().setText(congNhan.getString("gioiTinh"));
                this.getTuoiText().setText(String.valueOf(congNhan.getInt("tuoi")));
                this.getDiaChiText().setText(congNhan.getString("diaChi"));
                this.getSDTText().setText(congNhan.getString("SDT"));
                this.getEmailText().setText(congNhan.getString("email"));
                this.getViTriText().setText("Cong Nhan");
                this.getDetailText().setText(congNhan.getString("capBac"));
                break;
            case "null":
                JSONObject canBo = canBoDAO.GetId(IdCanBo);
                this.getTenText().setText(canBo.getString("ten"));
                this.getGioiTinhText().setText(canBo.getString("gioiTinh"));
                this.getTuoiText().setText(String.valueOf(canBo.getInt("tuoi")));
                this.getDiaChiText().setText(canBo.getString("diaChi"));
                this.getSDTText().setText(canBo.getString("SDT"));
                this.getEmailText().setText(canBo.getString("email"));
                break;
            default:
                break;
        }

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
        loginWindow.add(viTri);
        loginWindow.add(viTriText);
        loginWindow.add(INFO);
        loginWindow.add(dot);
        loginWindow.add(dot2);
        loginWindow.add(dot3);
        loginWindow.add(dot4);
        loginWindow.add(dot5);
        loginWindow.add(dot6);
        loginWindow.add(detail);
        loginWindow.add(detailText);
        loginWindow.add(edit);
        loginWindow.add(yesButt);
        loginWindow.add(noButt);
        loginWindow.add(logOutButt);
        try {
            BufferedImage yesImage = ImageIO.read(new File("/Users/mac/Documents/api/src/Resource/TrueIcon.png"));
            BufferedImage noImage = ImageIO.read(new File("/Users/mac/Documents/api/src/Resource/FalseIcon.png"));
            Image newYesImg = yesImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            Image newNoImg = noImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            yesButt.setIcon(new ImageIcon(newYesImg));
            noButt.setIcon(new ImageIcon(newNoImg));
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        INFO.setBounds(0, 50, 200, 20);
        ten.setBounds(71, 80, 30, 20);
        gioiTinh.setBounds(37, 110, 60, 20);
        tuoi.setBounds(67, 140, 50, 20);
        diaChi.setBounds(45, 170, 60, 20);
        SDT.setBounds(69, 200, 50, 20);
        email.setBounds(60, 230, 50, 20);
        viTri.setBounds(42, 260, 60, 20);
        detail.setBounds(32, 290, 100, 20);

        tenText.setBounds(120, 80, 300, 20);
        gioiTinhText.setBounds(120, 110, 300, 20);
        tuoiText.setBounds(120, 140, 300, 20);
        diaChiText.setBounds(120, 170, 300, 20);
        SDTText.setBounds(120, 200, 300, 20);
        emailText.setBounds(120, 230, 300, 20);
        viTriText.setBounds(120, 260, 300, 20);
        detailText.setBounds(120, 290, 300, 20);

        dot.setBounds(430, 80, 150, 20);
        dot2.setBounds(430, 110, 30, 20);
        dot3.setBounds(430, 140, 30, 20);
        dot4.setBounds(430, 170, 30, 20);
        dot5.setBounds(430, 200, 30, 20);
        dot6.setBounds(430, 230, 30, 20);


        edit.setBounds(120, 330, 70, 20);
        yesButt.setBounds(210, 330, 20, 20);
        noButt.setBounds(240, 330, 20, 20);

        tenText.setEditable(false);
        gioiTinhText.setEditable(false);
        tuoiText.setEditable(false);
        diaChiText.setEditable(false);
        SDTText.setEditable(false);
        emailText.setEditable(false);
        viTriText.setEditable(false);
        detailText.setEditable(false);
        yesButt.setVisible(false);
        noButt.setVisible(false);

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tenText.setEditable(true);
                gioiTinhText.setEditable(true);
                tuoiText.setEditable(true);
                EditInforFrame.this.getDiaChiText().setEditable(true);
                EditInforFrame.this.getSDTText().setEditable(true);
                EditInforFrame.this.getEmailText().setEditable(true);

                //TODO:Hien nut yes/no
                EditInforFrame.this.getYesButt().setVisible(true);
                EditInforFrame.this.getNoButt().setVisible(true);

                //TODO:Them hanh dong cho nut yes
                EditInforFrame.this.getYesButt().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String updateTen = EditInforFrame.this.getTenText().getText();
                        String updateGioiTinh = EditInforFrame.this.getGioiTinhText().getText();
                        int updateTuoi = Integer.parseInt(EditInforFrame.this.getTuoiText().getText());
                        String updateDiaChi = EditInforFrame.this.getDiaChiText().getText();
                        String updateSDT = EditInforFrame.this.getSDTText().getText();
                        String updateEmail = EditInforFrame.this.getEmailText().getText();
                        String updateChucVu = EditInforFrame.this.getViTriText().getText();
                        String updateDetail = EditInforFrame.this.getDetailText().getText();

                        //canBoDAO.Update(updateTen,updateGioiTinh,updateTuoi,updateDiaChi,updateSDT,updateEmail)
                        //TODO:Can chinh sua Update API: Update bang idCanBoCu va idCanBoMoi chua tuong minh
                        EditInforFrame.this.getYesButt().setVisible(false);
                        EditInforFrame.this.getNoButt().setVisible(false);

                        EditInforFrame.this.getTenText().setEditable(false);
                        EditInforFrame.this.getGioiTinhText().setEditable(false);
                        EditInforFrame.this.getTuoiText().setEditable(false);
                        EditInforFrame.this.getDiaChiText().setEditable(false);
                        EditInforFrame.this.getSDTText().setEditable(false);
                        EditInforFrame.this.getEmailText().setEditable(false);
                        EditInforFrame.this.getViTriText().setEditable(false);
                        EditInforFrame.this.getDetailText().setEditable(false);
                    }
                });

                //TODO:Them hanh dong cho nut no
                EditInforFrame.this.getNoButt().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        switch (IdPREFIX) {
                            case "NV":
                                try {
                                    JSONObject nhanVien = nhanVienDAO.GetById(IdCanBo);
                                    EditInforFrame.this.getTenText().setText(nhanVien.getString("ten"));
                                    EditInforFrame.this.getGioiTinhText().setText(nhanVien.getString("gioiTinh"));
                                    EditInforFrame.this.getTuoiText().setText(String.valueOf(nhanVien.getInt("tuoi")));
                                    EditInforFrame.this.getDiaChiText().setText(nhanVien.getString("diaChi"));
                                    EditInforFrame.this.getSDTText().setText(nhanVien.getString("SDT"));
                                    EditInforFrame.this.getEmailText().setText(nhanVien.getString("email"));
                                    EditInforFrame.this.getViTriText().setText("Nhan Vien");
                                    EditInforFrame.this.getDetailText().setText(nhanVien.getString("congViec"));
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                                break;
                            case "KS":
                                try {
                                    JSONObject kySu = kySuDao.GetById(IdCanBo);
                                    EditInforFrame.this.getTenText().setText(kySu.getString("ten"));
                                    EditInforFrame.this.getGioiTinhText().setText(kySu.getString("gioiTinh"));
                                    EditInforFrame.this.getTuoiText().setText(String.valueOf(kySu.getInt("tuoi")));
                                    EditInforFrame.this.getDiaChiText().setText(kySu.getString("diaChi"));
                                    EditInforFrame.this.getSDTText().setText(kySu.getString("SDT"));
                                    EditInforFrame.this.getEmailText().setText(kySu.getString("email"));
                                    EditInforFrame.this.getViTriText().setText("Ky Su");
                                    EditInforFrame.this.getDetailText().setText(kySu.getString("nganhDaoTao"));
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                break;
                            case "CN":
                                try {
                                    JSONObject congNhan = congNhanDao.GetById(IdCanBo);
                                    EditInforFrame.this.getTenText().setText(congNhan.getString("ten"));
                                    EditInforFrame.this.getGioiTinhText().setText(congNhan.getString("gioiTinh"));
                                    EditInforFrame.this.getTuoiText().setText(String.valueOf(congNhan.getInt("tuoi")));
                                    EditInforFrame.this.getDiaChiText().setText(congNhan.getString("diaChi"));
                                    EditInforFrame.this.getSDTText().setText(congNhan.getString("SDT"));
                                    EditInforFrame.this.getEmailText().setText(congNhan.getString("email"));
                                    EditInforFrame.this.getViTriText().setText("Cong Nhan");
                                    EditInforFrame.this.getDetailText().setText(congNhan.getString("capBac"));
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                                break;
                            case "null":
                                try {
                                    JSONObject canBo = canBoDAO.GetId(IdCanBo);
                                    EditInforFrame.this.getTenText().setText(canBo.getString("ten"));
                                    EditInforFrame.this.getGioiTinhText().setText(canBo.getString("gioiTinh"));
                                    EditInforFrame.this.getTuoiText().setText(String.valueOf(canBo.getInt("tuoi")));
                                    EditInforFrame.this.getDiaChiText().setText(canBo.getString("diaChi"));
                                    EditInforFrame.this.getSDTText().setText(canBo.getString("SDT"));
                                    EditInforFrame.this.getEmailText().setText(canBo.getString("email"));
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                                break;
                            default:
                                break;
                        }
                        EditInforFrame.this.getYesButt().setVisible(false);
                        EditInforFrame.this.getNoButt().setVisible(false);

                        EditInforFrame.this.getTenText().setEditable(false);
                        EditInforFrame.this.getGioiTinhText().setEditable(false);
                        EditInforFrame.this.getTuoiText().setEditable(false);
                        EditInforFrame.this.getDiaChiText().setEditable(false);
                        EditInforFrame.this.getSDTText().setEditable(false);
                        EditInforFrame.this.getEmailText().setEditable(false);
                        EditInforFrame.this.getViTriText().setEditable(false);
                        EditInforFrame.this.getDetailText().setEditable(false);
                    }
                });

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

    public JTextField getViTriText() {
        return viTriText;
    }

    public void setViTriText(JTextField viTriText) {
        this.viTriText = viTriText;
    }

    public JTextField getDetailText() {
        return detailText;
    }

    public void setDetailText(JTextField detailText) {
        this.detailText = detailText;
    }

    public JButton getEdit() {
        return edit;
    }

    public void setEdit(JButton edit) {
        this.edit = edit;
    }

    public JButton getYesButt() {
        return yesButt;
    }

    public void setYesButt(JButton yesButt) {
        this.yesButt = yesButt;
    }

    public JButton getNoButt() {
        return noButt;
    }

    public void setNoButt(JButton noButt) {
        this.noButt = noButt;
    }
}
