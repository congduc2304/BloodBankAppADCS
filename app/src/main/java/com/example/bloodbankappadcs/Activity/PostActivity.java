package com.example.bloodbankappadcs.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bloodbankappadcs.R;
import com.example.bloodbankappadcs.api.Server;

import java.util.HashMap;
import java.util.Map;

public class PostActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText edttenbenhnhan,edtsdtbenhnhan,edtemailbenhnhan,edtnhommaubenhnhan,edtdiachibenhnhan,edtbenhvienbenhnhan,edtngaydangbenhnhan,edtgioitinhbenhnhan;
    Button buttondangbai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Anhxa();
        ActionToolBar();
        EventButton();
    }
    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void EventButton() {
        buttondangbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ten = edttenbenhnhan.getText().toString().trim();
                final String sdt = edtsdtbenhnhan.getText().toString().trim();
                final String email = edtemailbenhnhan.getText().toString().trim();
                final String nhommau = edtnhommaubenhnhan.getText().toString().trim();
                final String diachi = edtdiachibenhnhan.getText().toString().trim();
                final String benhvien = edtbenhvienbenhnhan.getText().toString().trim();
                final String ngaydang = edtngaydangbenhnhan.getText().toString().trim();
                final String gioitinh = edtgioitinhbenhnhan.getText().toString().trim();
                if(ten.length()>0 && sdt.length()>0 && email.length()>0 && nhommau.length()>0 && diachi.length()>0 && benhvien.length()>0 && ngaydang.length()>0 && gioitinh.length()>0 ){
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdandonhang, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("manguoidung",response);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String,String> hashMap = new HashMap<String,String>();
                            hashMap.put("hoTen",ten);
                            hashMap.put("sdt",sdt);
                            hashMap.put("email",email);
                            hashMap.put("nhomMau",nhommau);
                            hashMap.put("diaChi",diachi);
                            hashMap.put("gioiTinh",gioitinh);
                            hashMap.put("tenBv",benhvien);
                            hashMap.put("ngayDang",ngaydang);
                            return hashMap;
                        }
                    };
                    requestQueue.add(stringRequest);
                    finish();
                }
            }
        });
    }

    private void Anhxa() {
        toolbar = (Toolbar) findViewById(R.id.toolbardienthoai);
        edttenbenhnhan = (EditText) findViewById(R.id.edttenbenhnhan);
        edtsdtbenhnhan = (EditText) findViewById(R.id.edtsdtbenhnhan);
        edtemailbenhnhan = (EditText) findViewById(R.id.edtemailbenhnhan);
        edtnhommaubenhnhan = (EditText) findViewById(R.id.edtnhommaubenhnhan);
        edtdiachibenhnhan = (EditText) findViewById(R.id.edtdiachibenhnhan);
        edtbenhvienbenhnhan = (EditText) findViewById(R.id.edtbenhvienbenhnhan);
        edtngaydangbenhnhan = (EditText) findViewById(R.id.edtngaydangbenhnhan);
        edtgioitinhbenhnhan = (EditText) findViewById(R.id.edtgioitinhbenhnhan);
        buttondangbai = (Button) findViewById(R.id.buttondangbai);
    }
}
