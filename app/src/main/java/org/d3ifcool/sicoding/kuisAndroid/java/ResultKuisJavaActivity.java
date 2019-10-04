package org.d3ifcool.sicoding.kuisAndroid.java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.beranda.BerandaActivity;

public class ResultKuisJavaActivity extends AppCompatActivity {
private Button menuawal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_kuis_java);
        TextView txtScore =  findViewById(R.id.textScore);
        TextView txtHighScore = findViewById(R.id.textHighScore);
        menuawal = findViewById(R.id.btn_menuAwal);

        menuawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultKuisJavaActivity.this, BerandaActivity.class));
                finish();
            }
        });

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        txtScore.setText("Your score: " + score);

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore = mypref.getInt("highscore",0);
        if(highscore>= score)
            txtHighScore.setText("High score: "+highscore);
        else
        {
            txtHighScore.setText("New highscore: "+score);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", score);
            editor.commit();
        }
    }

    public void onClick(View view) {
        Intent intent = new Intent(ResultKuisJavaActivity.this, KuisJavaActivity.class);
        startActivity(intent);
        finish();
    }
}
