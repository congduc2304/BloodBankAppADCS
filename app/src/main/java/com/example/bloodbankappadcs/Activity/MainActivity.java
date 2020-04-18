package com.example.bloodbankappadcs.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bloodbankappadcs.R;

public class MainActivity extends AppCompatActivity {
Button btnlogin , btnreg , btnforgot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ClickLogin();
        ClickReg();
        ClickForgotPass();
    }
    private void Anhxa()
    {
        btnlogin = (Button) findViewById(R.id.button_login);
        btnreg = (Button) findViewById(R.id.button_register);
        btnforgot = (Button) findViewById(R.id.button_forgot_password);
    }
    public void ClickLogin(){
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Home.class));
            }
        });
    }
    public void ClickReg(){
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });
    }
    public void ClickForgotPass(){
        btnforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ForgotPass.class));
            }
        });
    }
}
