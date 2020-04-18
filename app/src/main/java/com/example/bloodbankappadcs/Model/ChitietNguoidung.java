package com.example.bloodbankappadcs.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class ChitietNguoidung{
    private String nhomMau,sdt,ngayDang,email;

    public ChitietNguoidung(){

    }
    public ChitietNguoidung(JSONObject o) throws JSONException {
        nhomMau = o.getString("nhomMau");
        sdt = o.getString("sdt");
        ngayDang = o.getString("ngayDang");
        email = o.getString("email");
    }

    public ChitietNguoidung(String nhomMau, String sdt, String ngayDang, String email) {
        this.nhomMau = nhomMau;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
