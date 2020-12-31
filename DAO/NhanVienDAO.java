package DAO;

import Common.Common;
import Model.CanBo;
import Model.NhanVien;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class NhanVienDAO {
    private static final String path = "http://localhost:8080/TestWeb/nhanvien";
    private static final Gson gson = new Gson();

    public String GetAll() throws IOException {
        URL endPoint = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
        connection.setRequestMethod("GET");
        InputStream i = new BufferedInputStream(connection.getInputStream());
        String result = Common.convertToString(i);
        System.out.println(result);
        return result;
    }

    public JSONObject GetById(int IdNhanVien) throws IOException {
        URL endPoint = new URL( path + "?ID=" + IdNhanVien);
        HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        InputStream i = new BufferedInputStream(connection.getInputStream());
        String result = Common.convertToString(i);
        Gson gson = new Gson();
        String nhanVien = gson.toJson(result);
        JSONObject nhanVienObject = new JSONObject(result);
        System.out.println(result);
        return nhanVienObject;
    }

    public String Insert(int idCanBo, String congViec, String ten, String gioiTinh, int tuoi, String diaChi, String SDT, String email) throws IOException {
        URL endPoint = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        NhanVien nhanVien = new NhanVien(idCanBo, ten, gioiTinh, tuoi, diaChi, SDT, email, congViec);
        String nhanVienObject = gson.toJson(nhanVien);
        System.out.println(nhanVienObject);
        out.write(nhanVienObject);
        out.flush();
        out.close();
        InputStream i = new BufferedInputStream(connection.getInputStream());
        String result = Common.convertToString(i);
        return result;
    }

    public String UpdateThongTin(int idCanBoCu, int idCanBoMoi) {
        try {
            URL endPoint = new URL(path + "?IdCanBo=" + idCanBoCu + "&IdCanBoMoi=" + idCanBoMoi);
            HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            NhanVien nhanVien = new NhanVien(idCanBoCu, idCanBoMoi);
            String nhanVienObject = gson.toJson(nhanVien);
            out.write(nhanVienObject);
            out.flush();
            out.close();
            InputStream i = new BufferedInputStream(connection.getInputStream());
            String result = Common.convertToString(i);
            System.out.println(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String UpdateCongViec(String congViec, int idCanBo) {
        congViec = congViec.replaceAll(" ", "%20");
        try {
            URL endPoint = new URL(path + "?UpdateCongViec=true&CongViec=" + congViec + "&IdCanBo=" + idCanBo);
            HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            NhanVien nhanVien = new NhanVien(congViec, idCanBo);
            String nhanVienObject = gson.toJson(nhanVien);
            out.write(nhanVienObject);
            out.flush();
            out.close();
            InputStream i = new BufferedInputStream(connection.getInputStream());
            String result = Common.convertToString(i);
            System.out.println(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String DuoiViec(int IdCanBo) {
        try {
            URL endPoint = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            NhanVien nhanVien = new NhanVien(IdCanBo);
            String nhanVienObject = gson.toJson(nhanVien);
            out.write(nhanVienObject);
            out.flush();
            out.close();
            InputStream i = new BufferedInputStream(connection.getInputStream());
            String result = Common.convertToString(i);
            System.out.println(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
