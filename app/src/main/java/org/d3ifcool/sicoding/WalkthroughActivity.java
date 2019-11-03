package org.d3ifcool.sicoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import org.d3ifcool.sicoding.awal.login.login.LoginActivity;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class WalkthroughActivity extends AppCompatActivity {
    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btn_next, btn_getStarted;
    int position = 0;
    Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (restorePrefData()) {
            Intent intent = new Intent(WalkthroughActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        setContentView(R.layout.activity_walkthrough);
        try {
            InputStream inputStream = WalkthroughActivity.this.openFileInput("confirm.txt");
            Intent intent = new Intent(WalkthroughActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } catch (FileNotFoundException e) {
            System.out.println("File Tidak Ditemukan");
        }

        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.btn_intro_anim);
        btn_getStarted = findViewById(R.id.btn_getStarted);
        btn_next = findViewById(R.id.btn_nextIntro);
        tabIndicator = findViewById(R.id.tL_intro);

        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Materi", "Materi untuk mempelajari teori bahasa pemograman", R.drawable.logo));
        mList.add(new ScreenItem("Q&A", "Q&A untuk sesi tanya jawab seputar bahasa pemograman ", R.drawable.logo));
        mList.add(new ScreenItem("Contoh Codingan", "Contoh Codingan untuk membantu pengimplementasian bahasa pemograman", R.drawable.logo));
        mList.add(new ScreenItem("Kuis", "Kuis untuk mengetahui seberapa dalam pemahaman tentang bahasa pemograman", R.drawable.logo));

        screenPager = findViewById(R.id.vP_intro);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);

        tabIndicator.setupWithViewPager(screenPager);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = screenPager.getCurrentItem();
                if (position < mList.size()) {
                    position++;
                    screenPager.setCurrentItem(position);
                }

                if (position == mList.size()-1) {
                    loadLastScreen();
                }
            }
        });

        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-1) {
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btn_getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WalkthroughActivity.this, LoginActivity.class);
                startActivity(intent);

                savePrefsData();
                finish();
            }
        });
    }

    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend", true);
        editor.commit();
    }

    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isIntroOpnend", false);
        return isIntroActivityOpnendBefore;
    }

    private void loadLastScreen() {
        btn_next.setVisibility(View.INVISIBLE);
        btn_getStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.VISIBLE);

        btn_getStarted.setAnimation(btnAnim);
    }
}
