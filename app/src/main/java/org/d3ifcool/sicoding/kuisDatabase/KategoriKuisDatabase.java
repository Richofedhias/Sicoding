package org.d3ifcool.sicoding.kuisDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.kuisDatabase.firebase.KuisFirebaseActivity;
import org.d3ifcool.sicoding.kuisDatabase.json.KuisJsonActivity;
import org.d3ifcool.sicoding.kuisDatabase.mysql.KuisMysqlActivity;

public class KategoriKuisDatabase extends AppCompatActivity {
private Button json,mysql,firebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_kuis_database);

        json = findViewById(R.id.btn_json);
        mysql = findViewById(R.id.btn_mysql);
        firebase = findViewById(R.id.btn_firebase);

        json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KategoriKuisDatabase.this, KuisJsonActivity.class));
            }
        });

        mysql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KategoriKuisDatabase.this, KuisMysqlActivity.class));
            }
        });

        firebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KategoriKuisDatabase.this, KuisFirebaseActivity.class));
            }
        });

    }
}
