package com.example.bloodbankappadcs.api;

import android.os.AsyncTask;

import com.example.bloodbankappadcs.interfaces.LayNguoidungVe;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

public class ApiLaynguoidung extends AsyncTask<Void,Void,Void> {
    String data;
    LayNguoidungVe layNguoidungVe;

    public  ApiLaynguoidung(LayNguoidungVe layNguoidungVe){
        this.layNguoidungVe = layNguoidungVe;
        this.layNguoidungVe.batDau();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://dulieu223.000webhostapp.com/index.php/")
                .build();

        data = null;
        try {
            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            data = body.string();
        }catch (IOException e){
            data=null;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if(data == null){
            this.layNguoidungVe.biLoi();
        }else {
            this.layNguoidungVe.ketThuc(data);
        }
    }

}
