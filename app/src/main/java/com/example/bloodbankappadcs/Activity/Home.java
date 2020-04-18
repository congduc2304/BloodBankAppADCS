package com.example.bloodbankappadcs.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.bloodbankappadcs.Adapter.LoaispMenuAdapter;
import com.example.bloodbankappadcs.Adapter.NguoiDungAdapter;
import com.example.bloodbankappadcs.Model.ChitietNguoidung;
import com.example.bloodbankappadcs.Model.Loaisp_menu;
import com.example.bloodbankappadcs.Model.NguoiDung;
import com.example.bloodbankappadcs.R;
import com.example.bloodbankappadcs.api.ApiLaynguoidung;
import com.example.bloodbankappadcs.interfaces.LayNguoidungVe;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements LayNguoidungVe {
//ViewFlipper viewFlipper;
//ListView listViewmenu;
//DrawerLayout drawerLayout;
//NavigationView navigationView;
//Toolbar toolbar;
NavigationView navigationView;
Toolbar toolbar;
DrawerLayout drawerLayout;
ListView listViewmenu;

GridView gdvDSnguoidung;
NguoiDungAdapter adapter;
ArrayList<NguoiDung> nguoiDungArrayList;
ArrayList<ChitietNguoidung> chitietNguoidungArrayList;



ArrayList<Loaisp_menu> mangloaisp_menu;
LoaispMenuAdapter loaispMenuAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        Anhxa();
        SetUp();
        setClick();
        new ApiLaynguoidung(this).execute();

        ActionBar();
        CatchOnItemListView();

    }

    private void setClick() {
        gdvDSnguoidung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                NguoiDung nguoiDung = nguoiDungArrayList.get(i);
                Bundle b = new Bundle();
                b.putSerializable("chitiet",nguoiDung);
                Intent intent = new Intent(Home.this,DetailsActivity.class);
                intent.putExtra("data",b);
                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.donateinfo) {
            Intent intent = new Intent(getApplicationContext(),BloodInfo.class);
            startActivity(intent);
        }
        if (id == R.id.aboutusinfo) {
            Intent intent = new Intent(getApplicationContext(),AboutUs.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    private void init() {
        nguoiDungArrayList = new ArrayList<>();
        //dulieu ao
//        nguoiDungArrayList.add(new NguoiDung("A","Lý Minh Nhân","54654","6415465"));
//        nguoiDungArrayList.add(new NguoiDung("A","Bùi Khắc","65456","87654654"));
//        nguoiDungArrayList.add(new NguoiDung("AB","Huỳnh Quốc Bảo","546546","466546785"));
//        nguoiDungArrayList.add(new NguoiDung("O","Đinh Chánh Nghĩa","654645","898765464"));
//        nguoiDungArrayList.add(new NguoiDung("A","Nguyễn Kiều Hạnh Anh","54654","546549878"));
//        nguoiDungArrayList.add(new NguoiDung("O","Ngô An Bình","6546","123134178"));
//        nguoiDungArrayList.add(new NguoiDung("AB","Mai Ngọc Chân","546546","987982533"));

        adapter = new NguoiDungAdapter(this,0,nguoiDungArrayList);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    private void CatchOnItemListView() {
        listViewmenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                            Intent intent = new Intent(Home.this,Home.class);
                            startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        Intent intent1 = new Intent(Home.this,PostActivity.class);
                        startActivity(intent1);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                            Intent intent2 = new Intent(Home.this,ProfileActivity.class);
                            startActivity(intent2);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                            Intent intent3 = new Intent(Home.this,ThanhTuuActivity.class);
                            startActivity(intent3);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                            Intent intent4 = new Intent(Home.this,FindDonors.class);
                            startActivity(intent4);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 5:
                            Intent intent5 = new Intent(Home.this,NearHospitalActivity.class);
                            startActivity(intent5);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 6:
                            Intent intent6 = new Intent(Home.this,MainActivity.class);
                            startActivity(intent6);
                            drawerLayout.closeDrawer(GravityCompat.START);
                            break;
                }
            }
        });
    }

    private void Anhxa()
    {
        toolbar = findViewById(R.id.toolbarmanghinhchinh);
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        listViewmenu = (ListView) findViewById(R.id.listviewmenu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);

        //thanh menu
        mangloaisp_menu = new ArrayList<>();
        mangloaisp_menu.add(0,new Loaisp_menu(0,"Trang chính","https://img.icons8.com/dotty/80/000000/home.png"));
        mangloaisp_menu.add(1,new Loaisp_menu(1,"Đăng bài","https://img.icons8.com/carbon-copy/100/000000/plus--v1.png"));
        mangloaisp_menu.add(2,new Loaisp_menu(2,"Thông tin cá nhân","https://img.icons8.com/dotty/80/000000/life-cycle-female.png"));
        mangloaisp_menu.add(3,new Loaisp_menu(3,"Thành tựu","https://img.icons8.com/wired/64/000000/diploma.png"));
        mangloaisp_menu.add(4,new Loaisp_menu(4,"Tìm người hiến","https://img.icons8.com/dotty/80/000000/search.png"));
        mangloaisp_menu.add(5,new Loaisp_menu(5,"Bệnh viện gần nhất","https://img.icons8.com/dotty/80/000000/hospital-3.png"));
        mangloaisp_menu.add(6,new Loaisp_menu(6,"Đăng Xuất","https://img.icons8.com/carbon-copy/100/000000/export.png"));
        loaispMenuAdapter = new LoaispMenuAdapter(mangloaisp_menu,getApplicationContext());
        listViewmenu.setAdapter(loaispMenuAdapter);


        gdvDSnguoidung = findViewById(R.id.gdvDSnguoidung);
    }

    private void SetUp() {
        gdvDSnguoidung.setAdapter(adapter);
    }


    @Override
    public void batDau() {
        Toast.makeText(this,"Đang lấy về",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ketThuc(String data) {
        try{
            nguoiDungArrayList.clear();
            JSONArray arr = new JSONArray(data);
            for (int i=0;i<arr.length();i++){
                JSONObject o = arr.getJSONObject(i);
                nguoiDungArrayList.add(new NguoiDung(o));
            }
            adapter = new NguoiDungAdapter(this,0,nguoiDungArrayList);
            gdvDSnguoidung.setAdapter(adapter);
        }catch (JSONException e){

        }
    }

    @Override
    public void biLoi() {
        Toast.makeText(this,"Lỗi kết nối",Toast.LENGTH_SHORT).show();
    }

    public void Update(View view) {
        new ApiLaynguoidung(this).execute();
    }
}
