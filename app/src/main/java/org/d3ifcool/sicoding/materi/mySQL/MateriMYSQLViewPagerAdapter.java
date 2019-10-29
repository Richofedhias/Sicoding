package org.d3ifcool.sicoding.materi.mySQL;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.d3ifcool.sicoding.materi.mySQL.latihan.LatihanMYSQLFragment;
import org.d3ifcool.sicoding.materi.mySQL.materi.MateriMYSQLFragment;

public class MateriMYSQLViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;

    public MateriMYSQLViewPagerAdapter(Context mContext, @NonNull FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MateriMYSQLFragment();
        } else {
            return new LatihanMYSQLFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
