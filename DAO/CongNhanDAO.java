package DAO;

import Common.Common;
import Model.CongNhan;
import Model.KySu;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class CongNhanDAO {
    private static final String path = "http://localhost:8080/TestWeb/congnhan";
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

    public JSONObject GetById(int IdCongNhan) throws IOException {
        URL endPoint = new URL( path + "?ID=" + IdCongNhan);
        HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        InputStream i = new BufferedInputStream(connection.getInputStream());
        String result = Common.convertToString(i);
        Gson gson = new Gson();
        String congNhan = gson.toJson(result);
        JSONObject kySuObject = new JSONObject(result);
        System.out.println(result);
        return kySuObject;
    }

    public String Insert(int idCanBo, String capBac, String ten, String gioiTinh, int tuoi, String diaChi, String SDT, String email) throws IOException {
        URL endPoint = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        CongNhan congNhan = new CongNhan(idCanBo,ten,gioiTinh,tuoi,diaChi,SDT,email,capBac);
        String congNhanObject = gson.toJson(congNhan);
        System.out.println(congNhanObject);
        out.write(congNhanObject);
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
            CongNhan congNhan = new CongNhan(idCanBoCu, idCanBoMoi);
            String congNhanObject = gson.toJson(congNhan);
            out.write(congNhanObject);
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

    public String UpdateCapBac(String capBac, int idCanBo) {
        capBac = capBac.replaceAll(" ", "%20");
        try {
            URL endPoint = new URL(path + "?UpdateCapBac=true&CapBac=" + capBac + "&IdCanBo=" + idCanBo);
            HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            CongNhan congNhan = new CongNhan(capBac, idCanBo);
            String congNhanObject = gson.toJson(congNhan);
            out.write(congNhanObject);
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
            CongNhan congNhan = new CongNhan(IdCanBo);
            String kysSuObject = gson.toJson(congNhan);
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
