package org.d3ifcool.sicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.d3ifcool.sicoding.kuisAndroid.KategoriKuisAndroid;
import org.d3ifcool.sicoding.kuisDatabase.KategoriKuisDatabase;
import org.d3ifcool.sicoding.kuisWeb.KategoriKuisWeb;

public class KategoriKuisActivity extends AppCompatActivity {
private Button web,database,android;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_kuis);
        web = findViewById(R.id.btn_kategoriKuisWeb);
        database = findViewById(R.id.btn_kategoriKuisDatabase);
        android = findViewById(R.id.btn_kategoriKuisAndroid);

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KategoriKuisActivity.this, KategoriKuisWeb.class));
                finish();
            }
        });

        database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KategoriKuisActivity.this, KategoriKuisDatabase.class));
                finish();
            }
        });

        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KategoriKuisActivity.this, KategoriKuisAndroid.class));
                finish();
            }
        });
    }
}
