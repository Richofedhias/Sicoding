package org.d3ifcool.sicoding.materi.Firebase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.d3ifcool.sicoding.materi.Firebase.materi.MateriFireFragment;
import org.d3ifcool.sicoding.materi.HTML.PraktekFragment;
import org.d3ifcool.sicoding.materi.php.latihanPHP.LatihanPHPFragment;
import org.d3ifcool.sicoding.materi.php.materiPHP.MateriPHPFragment;

public class MateriFireViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;

    public MateriFireViewPagerAdapter(Context mContext, @NonNull FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MateriFireFragment();
        } else {
            return new MateriFireFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
