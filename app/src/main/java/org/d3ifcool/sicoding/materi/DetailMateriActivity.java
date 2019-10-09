package org.d3ifcool.sicoding.materi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.d3ifcool.sicoding.R;

import java.util.ArrayList;

public class DetailMateriActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra_judul";
    public static final String EXTRA_PENJELASAN = "extra_deskripsi";

    TextView deskripsi, judul;
    private ArrayList<MenuMateri> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_materi);
        judul = findViewById(R.id.tV_judulDetail);
        deskripsi = findViewById(R.id.tV_description);

        String extraTitle = getIntent().getStringExtra("title");
        String extraDesk = getIntent().getStringExtra("deskripsi");

        judul.setText(extraTitle);
        deskripsi.setText(extraDesk);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
