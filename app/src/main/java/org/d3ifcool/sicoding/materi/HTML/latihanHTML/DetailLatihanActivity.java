package org.d3ifcool.sicoding.materi.HTML.latihanHTML;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import org.d3ifcool.sicoding.R;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

public class DetailLatihanActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_judul";
    public static final String EXTRA_PENJELASAN = "extra_deskripsi";

    CodeView deskripsi;
    TextView  judul, hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_latihan);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        judul = findViewById(R.id.tV_judulLatihan);
        deskripsi = findViewById(R.id.tV_descLatihan);
        hasil = findViewById(R.id.tV_hasilLatihan);
        deskripsi.setTheme(CodeViewTheme.ANDROIDSTUDIO).fillColor();

        String extraname = getIntent().getStringExtra("judul");
        String extrapenj = getIntent().getStringExtra("penjelasan");

        judul.setText(extraname);
        deskripsi.showCode(extrapenj);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            hasil.setText(Html.fromHtml(extrapenj, Html.FROM_HTML_MODE_COMPACT));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
