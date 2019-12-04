package org.d3ifcool.sicoding.materi.php;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.d3ifcool.sicoding.materi.php.latihanPHP.LatihanPHPFragment;
import org.d3ifcool.sicoding.materi.php.materiPHP.MateriPHPFragment;

public class MateriPHPViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;

    public MateriPHPViewPagerAdapter(Context mContext, @NonNull FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MateriPHPFragment();
        } else{
            return new LatihanPHPFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
