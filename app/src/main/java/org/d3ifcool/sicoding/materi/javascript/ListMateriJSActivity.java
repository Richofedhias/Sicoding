package org.d3ifcool.sicoding.materi.javascript;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.materi.HTML.ListMateriActivity;
import org.d3ifcool.sicoding.materi.HTML.MateriViewPagerAdapter;

public class ListMateriJSActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    private int[] tabIcons = {
            R.drawable.ic_materi,
            R.drawable.ic_latihan,
            R.drawable.ic_praktek};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_materi_js);

        viewPager_tabLayout();
    }

    private void viewPager_tabLayout(){
        // Kodingan Untuk Mengatur View Pager
        viewPager = (ViewPager) findViewById(R.id.viewPager_Materi_js);
        MateriJSViewPagerAdapter adapter = new MateriJSViewPagerAdapter(ListMateriJSActivity.this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        // Kodingan Untuk Mengatur Tabs Layout
        tabLayout = (TabLayout) findViewById(R.id.tabs_materi_js);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }
}
