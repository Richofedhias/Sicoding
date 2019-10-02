package org.d3ifcool.sicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import org.d3ifcool.sicoding.login.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView top;
    Animation fromtop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        top = (ImageView) findViewById(R.id.iV_splash);
        fromtop = AnimationUtils.loadAnimation(this, R.anim.from_top);

        top.setAnimation(fromtop);
    }
}
