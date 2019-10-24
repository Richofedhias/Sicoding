package org.d3ifcool.sicoding.materi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import org.d3ifcool.sicoding.R;

public class DetailLatihanActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_judul";
    public static final String EXTRA_PENJELASAN = "extra_deskripsi";

    TextView deskripsi, judul, hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_latihan);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        judul = findViewById(R.id.tV_judulLatihan);
        deskripsi = findViewById(R.id.tV_descLatihan);
        hasil = findViewById(R.id.tV_hasilLatihan);

        String extraname = getIntent().getStringExtra("judul");
        String extrapenj = getIntent().getStringExtra("penjelasan");

        judul.setText(extraname);
        deskripsi.setText(extrapenj);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            hasil.setText(Html.fromHtml(extrapenj, Html.FROM_HTML_MODE_COMPACT));
        }
    }
}
