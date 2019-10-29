package org.d3ifcool.sicoding.materi.bootstrap.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import org.d3ifcool.sicoding.R;

public class DetailLatihanBSActivity extends AppCompatActivity {
    TextView deskripsi, judul, hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_latihan_bs);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        judul = findViewById(R.id.tV_judulLatihan_bs);
        deskripsi = findViewById(R.id.tV_descLatihan_bs);
        hasil = findViewById(R.id.tV_hasilLatihan_bs);

        String extraname = getIntent().getStringExtra("judul");
        String extrapenj = getIntent().getStringExtra("penjelasan");

        judul.setText(extraname);
        deskripsi.setText(extrapenj);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            hasil.setText(Html.fromHtml(extrapenj, Html.FROM_HTML_MODE_COMPACT));
        }
    }
}