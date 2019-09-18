package org.d3ifcool.sicoding.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.d3ifcool.sicoding.MenuMateri;
import org.d3ifcool.sicoding.MenuMateriActivity;
import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.beranda.BerandaActivity;
import org.d3ifcool.sicoding.register.RegisterActivity;



public class LoginActivity extends AppCompatActivity {
    private Button registrasi, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registrasi = findViewById(R.id.btn_registrasi);
        registrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        login = findViewById(R.id.btn_Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, BerandaActivity.class);
                startActivity(intent);
            }
        });
    }
}
