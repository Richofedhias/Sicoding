package org.d3ifcool.sicoding.materi.bootstrap.materi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.d3ifcool.sicoding.R;

public class DetailMateriBSActivity extends AppCompatActivity {
    TextView deskripsi, judul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_materi_bs);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        judul = findViewById(R.id.tV_judulDetail_bs);
        deskripsi = findViewById(R.id.tV_description_bs);

        //receive data
        String JudulMateri = getIntent().getStringExtra("judul");
        String DescMateri = getIntent().getStringExtra("deskripsi");

        //bind data
        judul.setText(JudulMateri);
        deskripsi.setText(DescMateri);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
