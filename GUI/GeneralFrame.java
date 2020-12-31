package GUI;

import DAO.CanBoDAO;
import DAO.CongNhanDAO;
import DAO.KySuDAO;
import DAO.NhanVienDAO;
import Model.CanBo;
import Model.CongNhan;
import Model.KySu;
import Model.NhanVien;
import com.google.gson.Gson;
import com.sun.xml.internal.fastinfoset.util.StringArray;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class GeneralFrame extends JFrame {
    private JPanel header;
    private JLabel id;
    private JLabel ten;
    private JLabel tuoi;
    private JLabel chucVu;
    private JLabel chuThich;
    private JLabel idValue;
    private JLabel tenValue;
    private JLabel tuoivalue;
    private JLabel chucVuValue;
    private JLabel chuThichvalue;
    private JButton edit;
    private JButton changePass;
    private JTable employeeList;
    private JPanel containPane;
    private  JPanel employTable;
    private GridLayout gridLayout = new GridLayout();
    private final CongNhanDAO congNhanDAO = new CongNhanDAO();
    private final KySuDAO kySuDAO = new KySuDAO();
    private final NhanVienDAO nhanVienDAO = new NhanVienDAO();
    private final Gson gson = new Gson();

    public GeneralFrame(String IdPREFIX, int IdCanBo, String username) throws IOException {
        setLayout(new BorderLayout());
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 700);
        ArrayList<String> canBoList = new ArrayList<>();

        this.containPane = new JPanel(new BorderLayout());
        this.employeeList = new JTable();
        this.header = new JPanel();
        this.id = new JLabel("ID:", JLabel.CENTER);
        this.ten = new JLabel("Tên:", JLabel.CENTER);
        this.tuoi = new JLabel("Tuoi:", JLabel.CENTER);
        this.chucVu = new JLabel("Chuc Vu:", JLabel.CENTER);
        this.idValue = new JLabel();
        this.tenValue = new JLabel();
        this.tuoivalue = new JLabel();
        this.chucVuValue = new JLabel();
        this.chuThichvalue = new JLabel();
        this.employeeList = new JTable();
        this.employTable = new JPanel();
        this.gridLayout = new GridLayout(2,10,10,10);

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        ArrayList<String> list = new ArrayList<>();
        list.add("Ten");
        list.add("Tuoi");
        list.add("Gioi Tinh");
        list.add("Dia Chi");
        list.add("SDT");
        list.add("Email");


        switch (IdPREFIX) {
            case "KS":
                this.chuThich = new JLabel("Nganh Dao Tao:", JLabel.CENTER);
                list.add(chuThich.getText());
                defaultTableModel.setColumnIdentifiers(list.toArray());
                String result = kySuDAO.GetAll();
                JSONArray KSArray = new JSONArray(result);

                for (int i = 0; i < KSArray.length(); i++) {
                    JSONObject obj = KSArray.getJSONObject(i);
                    KySu kySu = new KySu(obj.getInt("IdCanBo"), obj.getString("ten"),
                            obj.getString("gioiTinh"),
                            obj.getInt("tuoi"),
                            obj.getString("diaChi"),
                            obj.getString("SDT"),
                            obj.getString("email"), obj.getString("nganhDaoTao"));
                    canBoList.add(String.valueOf(kySu.getIDKySu()));
                    canBoList.add(kySu.getTen());
                    canBoList.add(kySu.getGioiTinh());
                    canBoList.add(String.valueOf(kySu.getTuoi()));
                    canBoList.add(kySu.getDiaChi());
                    canBoList.add(kySu.getSDT());
                    canBoList.add(kySu.getEmail());
                    canBoList.add(kySu.getNganhDaoTao());
                    defaultTableModel.addRow(canBoList.toArray());
                    canBoList.clear();
                }
                employeeList.setModel(defaultTableModel);

                JSONObject kySuObj = kySuDAO.GetById(IdCanBo);
                KySu kySuResult = gson.fromJson(String.valueOf(kySuObj) , KySu.class);
                idValue.setText(kySuResult.getIDKySu());
                tenValue.setText(kySuResult.getTen());
                tuoivalue.setText(String.valueOf(kySuResult.getTuoi()));
                chucVuValue.setText("Ky Su");
                chuThichvalue.setText(kySuResult.getNganhDaoTao());

                break;
            case "NV":
                this.chuThich = new JLabel("Cong Viec:", JLabel.CENTER);
                list.add(chuThich.getText());
                defaultTableModel.setColumnIdentifiers(list.toArray());
                String result1 = nhanVienDAO.GetAll();
                JSONArray NVArray = new JSONArray(result1);
                for (int i = 0; i < NVArray.length(); i++) {
                    JSONObject obj = NVArray.getJSONObject(i);
                    NhanVien kySu = new NhanVien(obj.getInt("IdCanBo"), obj.getString("ten"),
                            obj.getString("gioiTinh"),
                            obj.getInt("tuoi"),
                            obj.getString("diaChi"),
                            obj.getString("SDT"),
                            obj.getString("email"), obj.getString("congViec"));
                    canBoList.add(String.valueOf(kySu.getIDNhanVien()));
                    canBoList.add(kySu.getTen());
                    canBoList.add(kySu.getGioiTinh());
                    canBoList.add(String.valueOf(kySu.getTuoi()));
                    canBoList.add(kySu.getDiaChi());
                    canBoList.add(kySu.getSDT());
                    canBoList.add(kySu.getEmail());
                    canBoList.add(kySu.getCongViec());
                    defaultTableModel.addRow(canBoList.toArray());
                    canBoList.clear();
                }
                employeeList.setModel(defaultTableModel);

                JSONObject nhanVienObj = nhanVienDAO.GetById(IdCanBo);
                NhanVien nhanVienResult = gson.fromJson(String.valueOf(nhanVienObj) , NhanVien.class);
                idValue.setText(IdPREFIX+IdCanBo);
                tenValue.setText(nhanVienResult.getTen());
                tuoivalue.setText(String.valueOf(nhanVienResult.getTuoi()));
                chucVuValue.setText("Nhan Vien");
                chuThichvalue.setText(nhanVienResult.getCongViec());

                break;
            case "CN":
                this.chuThich = new JLabel("Cap Bac:", JLabel.CENTER);
                list.add(chuThich.getText());
                defaultTableModel.setColumnIdentifiers(list.toArray());
                String result2 = congNhanDAO.GetAll();
                JSONArray CNArray = new JSONArray(result2);
                for (int i = 0; i < CNArray.length(); i++) {
                    JSONObject obj = CNArray.getJSONObject(i);
                    CongNhan congNhan = new CongNhan(obj.getInt("IdCanBo"), obj.getString("ten"),
                            obj.getString("gioiTinh"),
                            obj.getInt("tuoi"),
                            obj.getString("diaChi"),
                            obj.getString("SDT"),
                            obj.getString("email"), obj.getString("capBac"));
                    canBoList.add(String.valueOf(congNhan.getIDNhanVien()));
                    canBoList.add(congNhan.getTen());
                    canBoList.add(congNhan.getGioiTinh());
                    canBoList.add(String.valueOf(congNhan.getTuoi()));
                    canBoList.add(congNhan.getDiaChi());
                    canBoList.add(congNhan.getSDT());
                    canBoList.add(congNhan.getEmail());
                    canBoList.add(congNhan.getCapBac());
                    defaultTableModel.addRow(canBoList.toArray());
                    canBoList.clear();
                }
                employeeList.setModel(defaultTableModel);

                JSONObject congNhanObj = congNhanDAO.GetById(IdCanBo);
                CongNhan congNhanResult = gson.fromJson(String.valueOf(congNhanObj) , CongNhan.class);
                idValue.setText(congNhanResult.getIDNhanVien());
                tenValue.setText(congNhanResult.getTen());
                tuoivalue.setText(String.valueOf(congNhanResult.getTuoi()));
                chucVuValue.setText("Cong Nhan");
                chuThichvalue.setText(congNhanResult.getCapBac());

                break;
            default:
                break;
        }
        this.edit = new JButton("Edit");
        this.changePass = new JButton("Change password");

        header.setBorder(new EmptyBorder(10,0,30,0));
        header.setSize(600, 300);
        employeeList.setSize(600,400);
        employTable.setSize(600,400);

        employTable.add(employeeList);

        header.setLayout(gridLayout);
/*
        id.setBounds(10,5,20,20);
        idValue.setBounds(40,5,50,20);
        ten.setBounds(100,5,20,20);
        tenValue.setBounds(130,5,50,20);
        tuoi.setBounds(190,5,25,20);
        tenValue.setBounds(225,5,50,20);

 */

        header.add(id);
        header.add(idValue);
        header.add(ten);
        header.add(tenValue);
        header.add(tuoi);
        header.add(tuoivalue);
        header.add(chucVu);
        header.add(chucVuValue);
        header.add(chuThich);
        header.add(chuThichvalue);
        header.add(edit);
        header.add(changePass);

        containPane.add(header,BorderLayout.NORTH);
        containPane.add(employTable);

       setContentPane(containPane);

       edit.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               GeneralFrame.this.setVisible(false);
               try {
                   EditInforFrame editInforFrame = new EditInforFrame(IdPREFIX,IdCanBo);
               } catch (IOException exception) {
                   exception.printStackTrace();
               }
           }
       });

       changePass.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               EditPasswrodFrame editPasswrodFrame = new EditPasswrodFrame(username);
           }
       });

       pack();
    }

    public JLabel getIdValue() {
        return idValue;
    }

    public void setIdValue(JLabel idValue) {
        this.idValue = idValue;
    }

    public JLabel getTenValue() {
        return tenValue;
    }

    public void setTenValue(JLabel tenValue) {
        this.tenValue = tenValue;
    }

    public JLabel getTuoivalue() {
        return tuoivalue;
    }

    public void setTuoivalue(JLabel tuoivalue) {
        this.tuoivalue = tuoivalue;
    }

    public JLabel getChucVuValue() {
        return chucVuValue;
    }

    public void setChucVuValue(JLabel chucVuValue) {
        this.chucVuValue = chucVuValue;
    }

    public JLabel getChuThichvalue() {
        return chuThichvalue;
    }

    public void setChuThichvalue(JLabel chuThichvalue) {
        this.chuThichvalue = chuThichvalue;
    }

    public JButton getEdit() {
        return edit;
    }

    public void setEdit(JButton edit) {
        this.edit = edit;
    }

    public JButton getChangePass() {
        return changePass;
    }

    public void setChangePass(JButton changePass) {
        this.changePass = changePass;
    }
}
