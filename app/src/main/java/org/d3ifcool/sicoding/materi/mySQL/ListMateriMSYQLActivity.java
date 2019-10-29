package org.d3ifcool.sicoding.materi.mySQL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.materi.JSON.ListMateriJSONActivity;
import org.d3ifcool.sicoding.materi.JSON.MateriJSONViewPagerAdapter;

public class ListMateriMSYQLActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    private int[] tabIcons = {
            R.drawable.ic_materi,
            R.drawable.ic_latihan
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_materi_msyql);
        viewPager_tabLayout();
    }

    private void viewPager_tabLayout(){
        // Kodingan Untuk Mengatur View Pager
        viewPager = (ViewPager) findViewById(R.id.viewPager_Materi_mysql);
        MateriMYSQLViewPagerAdapter adapter = new MateriMYSQLViewPagerAdapter(ListMateriMSYQLActivity.this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        // Kodingan Untuk Mengatur Tabs Layout
        tabLayout = (TabLayout) findViewById(R.id.tabs_materi_mysql);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }
}
