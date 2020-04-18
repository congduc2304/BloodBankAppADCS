package com.example.bloodbankappadcs.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bloodbankappadcs.Model.ChitietNguoidung;
import com.example.bloodbankappadcs.Model.NguoiDung;
import com.example.bloodbankappadcs.R;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity{
TextView txvTenChitiet , txvNhommauchitiet , txvSdtchitiet , txvNgaydangchitiet , txvEmailchitiet;
ImageView imgAnhChitiet;
NguoiDung nguoiDung;

Toolbar toolbar;

ArrayList<ChitietNguoidung> arrChitiet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();
        anhXa();
        ActionToolBar();
        setUp();
        setClick();
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
    private void init(){
        Bundle b = getIntent().getBundleExtra("data");
        nguoiDung = (NguoiDung) b.getSerializable("chitiet");
//
//        //dulieu ao
        arrChitiet = new ArrayList<>();
//        arrChitiet.add(new ChitietNguoidung("O+","0123459999","20/1/2010","nhantp2013@gmail.com"));
//        chitietAdapter=new ChitietAdapter(this,0,arrChitiet);
    }
    private void anhXa(){
        imgAnhChitiet = findViewById(R.id.imgAnhChitiet);
        txvTenChitiet = findViewById(R.id.txvTenChitiet);
        txvNhommauchitiet = findViewById(R.id.txvNhommauchitiet);
        txvSdtchitiet = findViewById(R.id.txvSdtchitiet);
        txvNgaydangchitiet = findViewById(R.id.txvNgaydangchitiet);
        txvEmailchitiet = findViewById(R.id.txvEmailchitiet);
        toolbar = (Toolbar) findViewById(R.id.toolbardienthoai);
//        lsvDanhSachchitiet = findViewById(R.id.lsvDanhSachchitiet);
    }
    private void setUp(){
        txvTenChitiet.setText(nguoiDung.getTenNguoidung());
        txvNhommauchitiet.setText(nguoiDung.getNhomMau());
        txvSdtchitiet.setText(nguoiDung.getSdt());
        txvNgaydangchitiet.setText(nguoiDung.getNgayDang());
        txvEmailchitiet.setText(nguoiDung.getEmail());

//        lsvDanhSachchitiet.setAdapter(chitietAdapter);
    }
    private void setClick(){}
}
