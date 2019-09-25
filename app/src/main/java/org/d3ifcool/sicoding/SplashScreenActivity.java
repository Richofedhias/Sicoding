package org.d3ifcool.sicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import org.d3ifcool.sicoding.login.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // langsung pindah ke MainActivity
        // begitu memasuki splash screen ini
        Intent intent = new Intent(this, WalkthroughActivity.class);
        startActivity(intent);
        finish();

    }
}
