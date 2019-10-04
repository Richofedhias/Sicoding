package org.d3ifcool.sicoding.kuisWeb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.kuisWeb.css.KuisCSSActivity;
import org.d3ifcool.sicoding.kuisWeb.html.KuisHTMLActivity;
import org.d3ifcool.sicoding.kuisWeb.php.KuisPHPActivity;
import org.d3ifcool.sicoding.kuisWeb.boostrap.KuisBoostrapActivity;
import org.d3ifcool.sicoding.kuisWeb.javascript.KuisJavaScriptActivity;

public class KategoriKuisWeb extends AppCompatActivity {
private Button html,php,css,boostrap,javascript;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_kuis_web);
        html = findViewById(R.id.btn_html);
        php = findViewById(R.id.btn_php);
        css = findViewById(R.id.btn_css);
        boostrap = findViewById(R.id.btn_boostrap);
        javascript = findViewById(R.id.btn_javascript);

        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KategoriKuisWeb.this, KuisHTMLActivity.class));
                finish();
            }
        });

        php.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KategoriKuisWeb.this, KuisPHPActivity.class));
                finish();
            }
        });

        css.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KategoriKuisWeb.this, KuisCSSActivity.class));
                finish();
            }
        });

        boostrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KategoriKuisWeb.this, KuisBoostrapActivity.class));
                finish();
            }
        });

        javascript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KategoriKuisWeb.this, KuisJavaScriptActivity.class));
                finish();
            }
        });
    }
}
