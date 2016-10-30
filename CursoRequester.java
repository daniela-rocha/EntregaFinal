package com.example.lucassouza.myprojectapp.Model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CursoRequester {
    OkHttpClient client = new OkHttpClient();


    public ArrayList<Curso> get (String url, String chave) throws IOException{
        ArrayList<Curso> lista = new ArrayList<>();
        System.out.println(url);
        Request request = new Request.Builder().url(url).build();
        System.out.println(request);
        Response response;
        response = client.newCall(request).execute();
        System.out.println(response);
        String jsonString = response.body().string();
        System.out.println(jsonString);
        try{
            JSONArray root = new JSONArray(jsonString);
            JSONObject item = null;
            for(int i = 0; i < root.length(); i++){
                item = (JSONObject)root.get(i);

                int id = item.getInt("id");
                String nome = item.getString("nome");
                String dataIni = item.getString("dataIni");
                String dataTer = item.getString("dataTer");
                String horario = item.getString("horario");
                Double valor = item.getDouble("valor");
                int numeroVagas = item.getInt("numeroVagas");

                lista.add(new Curso(id, nome, dataIni, dataTer, horario, valor, numeroVagas));
            }
        } catch (JSONException e){
            throw new IOException(e);
        } finally {
            if(lista.size() == 0){
                lista.add(new Curso());
            }
        }
        return lista;
    }
    public Bitmap getImage(String url) throws IOException{
        Bitmap img = null;

        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        InputStream is = response.body().byteStream();

        img = BitmapFactory.decodeStream(is);

        is.close();

        return img;
    }

    public boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
