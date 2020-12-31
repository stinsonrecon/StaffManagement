package DAO;

import Common.Common;
import Model.KySu;
import Model.NhanVien;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class KySuDAO {
    private static final String path = "http://localhost:8080/TestWeb/kysu";
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

    public JSONObject GetById(int IdKySu) throws IOException {
        URL endPoint = new URL( path + "?ID=" + IdKySu);
        HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        InputStream i = new BufferedInputStream(connection.getInputStream());
        String result = Common.convertToString(i);
        Gson gson = new Gson();
        String kySu = gson.toJson(result);
        JSONObject kySuObject = new JSONObject(result);
        System.out.println(result);
        return kySuObject;
    }

    public String Insert(int idCanBo, String nganhDaoTao, String ten, String gioiTinh, int tuoi, String diaChi, String SDT, String email) throws IOException {
        URL endPoint = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        KySu kySu = new KySu(idCanBo,ten,gioiTinh,tuoi,diaChi,SDT,email,nganhDaoTao);
        String kySuObject = gson.toJson(kySu);
        System.out.println(kySuObject);
        out.write(kySuObject);
        out.flush();
        out.close();
        InputStream i = new BufferedInputStream(connection.getInputStream());
        String result = Common.convertToString(i);
        return result;
    }

    public String UpdateThongTin(int idCanBoCu, int idCanBoMoi) {
        try {
            URL endPoint = new URL(path + "?IdCanBoCu=" + idCanBoCu + "&IdCanBoMoi=" + idCanBoMoi);
            HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            KySu kySu = new KySu(idCanBoCu, idCanBoMoi);
            String kySuObject = gson.toJson(kySu);
            out.write(kySuObject);
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

    public String UpdateNganhDaoTao(String nganhDaoTao, int idCanBo) {
        nganhDaoTao = nganhDaoTao.replaceAll(" ", "%20");
        try {
            URL endPoint = new URL(path + "?UpdateNganhDaoTao=true&NganhDaoTao=" + nganhDaoTao + "&IdCanBo=" + idCanBo);
            HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            KySu kySu = new KySu(nganhDaoTao, idCanBo);
            String kySuObject = gson.toJson(kySu);
            out.write(kySuObject);
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
            KySu kySu = new KySu(IdCanBo);
            String kysSuObject = gson.toJson(kySu);
            out.write(kysSuObject);
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
