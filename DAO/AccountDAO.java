package DAO;

import Common.Common;
import Model.*;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class AccountDAO {
    private static final Gson gson = new Gson();

    public CanBo createCanBo(String ten,
                             String gioiTinh,
                             int tuoi,
                             String diaChi,
                             String SDT,
                             String email) throws IOException {
        CanBoDAO canBoDAO = new CanBoDAO();
        CanBo canBo = canBoDAO.Insert(ten, gioiTinh, tuoi, diaChi, SDT, email);
        System.out.println(canBo);
        return canBo;
    }

    public String CreateAccNV(String username, String password, CanBo canBo, String congViec) throws IOException {
        URL endPoint = new URL("http://localhost:8080/TestWeb/account?type=NV");
        HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
        connection.setRequestMethod("OPTIONS");
        connection.setDoInput(true);
        connection.setDoOutput(true);

        System.out.println(canBo.toString());
        NhanVien nhanVien = new NhanVien(canBo.getIdCanBo(), canBo.getTen(), canBo.getGioiTinh(), canBo.getTuoi(), canBo.getDiaChi(), canBo.getSDT(), canBo.getEmail(), congViec);

        Account account = new Account(username, password, "NV", nhanVien.getIdCanBo());

        String jsonArray = "[" + gson.toJson(nhanVien) + ", " + gson.toJson(account) + "]";
        System.out.println(jsonArray);

        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        out.write(jsonArray);
        out.flush();
        out.close();
        InputStream i = new BufferedInputStream(connection.getInputStream());
        String result = Common.convertToString(i);
        return result;
    }

    public String CreateAccKS(String username, String password, CanBo canBo, String nganhdaotao) throws IOException {
        URL endPoint = new URL("http://localhost:8080/TestWeb/account?type=KS");
        HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
        connection.setRequestMethod("OPTIONS");
        connection.setDoInput(true);
        connection.setDoOutput(true);

        System.out.println(canBo.toString());
        KySu kySu = new KySu(canBo.getIdCanBo(), canBo.getTen(), canBo.getGioiTinh(), canBo.getTuoi(), canBo.getDiaChi(), canBo.getSDT(), canBo.getEmail(), nganhdaotao);

        Account account = new Account(username, password, "KS", kySu.getIdCanBo());

        String jsonArray = "[" + gson.toJson(kySu) + ", " + gson.toJson(account) + "]";
        System.out.println(jsonArray);

        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        out.write(jsonArray);
        out.flush();
        out.close();
        InputStream i = new BufferedInputStream(connection.getInputStream());
        String result = Common.convertToString(i);
        return result;
    }

    public String CreateAccCN(String username, String password, CanBo canBo, String capBac) throws IOException {
        URL endPoint = new URL("http://localhost:8080/TestWeb/account?type=CN");
        HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
        connection.setRequestMethod("OPTIONS");
        connection.setDoInput(true);
        connection.setDoOutput(true);

        CongNhan congNhan = new CongNhan(canBo.getIdCanBo(), canBo.getTen(), canBo.getGioiTinh(), canBo.getTuoi(), canBo.getDiaChi(), canBo.getSDT(), canBo.getEmail(), capBac);

        Account account = new Account(username, password, "CN", congNhan.getIdCanBo());

        String jsonArray = "[" + gson.toJson(congNhan) + ", " + gson.toJson(account) + "]";

        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        out.write(jsonArray);
        out.flush();
        out.close();
        InputStream i = new BufferedInputStream(connection.getInputStream());
        String result = Common.convertToString(i);
        return result;
    }

    public JSONObject Login(Account account) throws IOException {

        URL endPoint = new URL("http://localhost:8080/TestWeb/account");
        HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);

        String loginAccount = gson.toJson(account);
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        out.write(loginAccount);
        out.flush();
        out.close();
        InputStream i = new BufferedInputStream(connection.getInputStream());
        String result = Common.convertToString(i);
        System.out.println(result);
        JSONObject obj = new JSONObject(result);
        i.close();
        return obj;

    }
}

