package com.example.bloodbankappadcs.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class NguoiDung implements Serializable {
    private String nhomMau,tenNguoidung,sdt,ngayDang,id,email;

    public NguoiDung(JSONObject o) throws JSONException{
        id = o.getString("id");
        nhomMau = o.getString("nhomMau");
        tenNguoidung = o.getString("tenNguoidung");
        sdt = o.getString("sdt");
        ngayDang = o.getString("ngayDang");
        email = o.getString("email");

    }

    public NguoiDung(String nhomMau, String tenNguoidung, String sdt, String ngayDang, String email) {
        this.nhomMau = nhomMau;
        this.tenNguoidung = tenNguoidung;
        this.sdt = sdt;
        this.ngayDang = ngayDang;
        this.email = email;
    }

    public String getNhomMau() {
        return nhomMau;
    }

    public void setNhomMau(String nhomMau) {
        this.nhomMau = nhomMau;
    }

    public String getTenNguoidung() {
        return tenNguoidung;
    }

    public void setTenNguoidung(String tenNguoidung) {
        this.tenNguoidung = tenNguoidung;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(String ngayDang) {
        this.ngayDang = ngayDang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
