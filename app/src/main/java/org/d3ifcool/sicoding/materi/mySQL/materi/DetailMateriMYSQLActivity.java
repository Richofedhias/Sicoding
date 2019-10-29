package org.d3ifcool.sicoding.materi.mySQL.materi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.d3ifcool.sicoding.R;

public class DetailMateriMYSQLActivity extends AppCompatActivity {
    TextView deskripsi, judul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_materi_mysql);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        judul = findViewById(R.id.tV_judulDetail_mysql);
        deskripsi = findViewById(R.id.tV_description_mysql);

        //receive data
        String JudulMateri = getIntent().getStringExtra("judul");
        String DescMateri = getIntent().getStringExtra("deskripsi");

        //bind data
        judul.setText(JudulMateri);
        deskripsi.setText(DescMateri);

    }
}
