package DAO;

import Common.Common;
import Model.CanBo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CanBoDAO {
    private static final String path = "http://localhost:8080/TestWeb/canbo";

    public String GetAll() throws IOException {
        URL endPoint = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
        connection.setRequestMethod("GET");
        InputStream i = new BufferedInputStream(connection.getInputStream());
        String result = Common.convertToString(i);
        System.out.println(result);
        return result;
    }
    public JSONObject GetId(int IdCanBo) throws IOException {
        URL endPoint = new URL("http://localhost:8080/TestWeb/canbo?ID="+IdCanBo);
        HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        InputStream i = new BufferedInputStream(connection.getInputStream());
        String result = Common.convertToString(i);
        Gson gson = new Gson();
        String canBo = gson.toJson(result);
        JSONObject canBoObject = new JSONObject(result);
        System.out.println(result);
        return canBoObject;
    }

    public CanBo Insert(String ten, String gioiTinh, int tuoi, String diaChi, String SDT, String email) throws IOException{
        /*
        URL endPoint = new URL("http://localhost:8080/TestWeb/canbo?Ten=" + ten + "&GioiTinh=" + gioTinh + "&Tuoi=" + tuoi + "&DiaChi=" + diaChi + "&SDT=" + SDT + "&Email=" + email);
        HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
        connection.setRequestMethod("POST");
        InputStream i = new BufferedInputStream(connection.getInputStream());
        String result = Common.convertToString(i);
        return result;

         */
        URL endPoint = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        Gson gson = new Gson();
        CanBo canBo = new CanBo(ten,gioiTinh,tuoi,diaChi,SDT,email);
        String canBoObject = gson.toJson(canBo);
        //System.out.println(canBoObject);
        out.write(canBoObject);
        out.flush();
        out.close();
        InputStream i = new BufferedInputStream(connection.getInputStream());
        String result = Common.convertToString(i);
        System.out.println(result);
        if(result.equals("Insert that bai")){
            System.out.println("that bai");
            return null;
        }
        else {
            CanBo canBo1 = gson.fromJson(result,CanBo.class);
            System.out.println("Thanh cong");
            System.out.println(result);
            return canBo1;
        }
    }

    public String Update(String ten, String gioiTinh, int tuoi, String diaChi, String SDT, String email, int idCanBo) throws IOException{
        URL endPoint = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) endPoint.openConnection();
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        Gson gson = new Gson();
        CanBo canBo = new CanBo(idCanBo, ten,gioiTinh,tuoi,diaChi,SDT,email);
        String canBoObject = gson.toJson(canBo);
        out.write(canBoObject);
        out.flush();
        out.close();
        InputStream i = new BufferedInputStream(connection.getInputStream());
        String result = Common.convertToString(i);
        return result;
    }


}
