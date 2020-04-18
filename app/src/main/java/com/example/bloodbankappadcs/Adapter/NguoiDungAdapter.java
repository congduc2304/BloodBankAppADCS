package com.example.bloodbankappadcs.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.bloodbankappadcs.Model.NguoiDung;
import com.example.bloodbankappadcs.R;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungAdapter extends ArrayAdapter<NguoiDung> {
    private Context ct;
    private ArrayList<NguoiDung> arr;
    public NguoiDungAdapter(@NonNull Context context, int resource, @NonNull List<NguoiDung> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(R.layout.dong_nguoidung,null);
        }
        if(arr.size()>0){
            NguoiDung nguoiDung = this.arr.get(position);

            TextView nhomMau = convertView.findViewById(R.id.textviewnhommau);
            TextView tenNguoidung = convertView.findViewById(R.id.textviewdangboi);
            TextView sdt = convertView.findViewById(R.id.textviewsdt);
            TextView ngayDang = convertView.findViewById(R.id.textviewpost);

//            ImageView  = convertView.findViewById(R.id.);

            nhomMau.setText(nguoiDung.getNhomMau());
            tenNguoidung.setText(nguoiDung.getTenNguoidung());
            sdt.setText(nguoiDung.getSdt());
            ngayDang.setText(nguoiDung.getNgayDang());

        }
        return convertView;
    }
}
