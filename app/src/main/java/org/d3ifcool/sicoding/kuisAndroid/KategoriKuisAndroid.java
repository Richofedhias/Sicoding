package org.d3ifcool.sicoding.kuisAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.kuisAndroid.java.KuisJavaActivity;
import org.d3ifcool.sicoding.kuisAndroid.kotlin.KuisKotlinActivity;

public class KategoriKuisAndroid extends AppCompatActivity {
private Button java,kotlin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_kuis_android);

        java = findViewById(R.id.btn_java);
        kotlin = findViewById(R.id.btn_kotlin);

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KategoriKuisAndroid.this, KuisJavaActivity.class));
            }
        });

        kotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KategoriKuisAndroid.this, KuisKotlinActivity.class));
            }
        });
    }
}
