package org.d3ifcool.sicoding.beranda;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.d3ifcool.sicoding.AboutActivity;
import org.d3ifcool.sicoding.KategoriKuisActivity;
import org.d3ifcool.sicoding.ProfileActivity;
import org.d3ifcool.sicoding.QnA.QnAActivity;
import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.awal.login.login.LoginActivity;

public class BerandaActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton, fab1, fab2;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;
    BottomAppBar bottomAppBar;
    ViewPager viewPager;
    boolean isOpen = false;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        viewPager = (ViewPager) findViewById(R.id.vP_beranda);
        IsiBerandaAdapter utangAdapter = new IsiBerandaAdapter(BerandaActivity.this, getSupportFragmentManager());
        viewPager.setAdapter(utangAdapter);

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
                        break;
                }
                return true;
            }
        });

        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BerandaActivity.this, AboutActivity.class));
            }
        });

        holdFloatingActionButton();
    }

    private void holdFloatingActionButton() {
        floatingActionButton = findViewById(R.id.fab_index);
        fab1 = findViewById(R.id.fab1);
        fab2 = findViewById(R.id.fab2);

        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this,R.anim.fab_close);

        rotateForward = AnimationUtils.loadAnimation(this, R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(this, R.anim.rotate_backward);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BerandaActivity.this, KategoriKuisActivity.class);
                startActivity(intent);
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BerandaActivity.this, QnAActivity.class);
                startActivity(intent);
            }
        });
    }

    private void animateFab() {
        if (isOpen) {
            floatingActionButton.startAnimation(rotateForward);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isOpen = false;
        }else {
            floatingActionButton.startAnimation(rotateBackward);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isOpen = true;
        }
    }


}
