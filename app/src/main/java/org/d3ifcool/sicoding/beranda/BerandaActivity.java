package org.d3ifcool.sicoding.beranda;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.d3ifcool.sicoding.ProfileActivity;
import org.d3ifcool.sicoding.R;

public class BerandaActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    BottomAppBar bottomAppBar;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        viewPager = (ViewPager) findViewById(R.id.vP_beranda);
        IsiBerandaAdapter utangAdapter = new IsiBerandaAdapter(BerandaActivity.this, getSupportFragmentManager());
        viewPager.setAdapter(utangAdapter);

        // Kodingan Untuk Mengatur Tabs Layout
//        tabLayout = (TabLayout) findViewById(R.id.tabs_hutang);
//        tabLayout.setupWithViewPager(viewPager);

        //Bottom Navigation View
        bottomAppBar = findViewById(R.id.bottom_app_bar);
        bottomAppBar.replaceMenu(R.menu.bottom_nav_menu);
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_profile:
                        Intent intent = new Intent(BerandaActivity.this, ProfileActivity.class);
                        startActivity(intent);
                        Toast.makeText(BerandaActivity.this, "Berhasil ke Halaman Profil", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BerandaActivity.this, "Berhasil Beranda", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void holdFloatingActionButton() {

    }
}
