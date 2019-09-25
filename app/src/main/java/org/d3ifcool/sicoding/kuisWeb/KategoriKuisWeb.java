package org.d3ifcool.sicoding.kuisWeb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.d3ifcool.sicoding.R;

public class KategoriKuisWeb extends AppCompatActivity {
private Button html,php;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_kuis_web);
        html = findViewById(R.id.btn_html);
        php = findViewById(R.id.btn_php);

        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KategoriKuisWeb.this,KuisWebActivity.class));
            }
        });
    }
}
