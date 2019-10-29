package org.d3ifcool.sicoding.materi.AndroidJava;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.d3ifcool.sicoding.materi.AndroidJava.latihan.LatihanAndJFragment;
import org.d3ifcool.sicoding.materi.AndroidJava.materi.MateriAndJFragment;

public class MateriAndroidJViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;

    public MateriAndroidJViewPagerAdapter(Context mContext, @NonNull FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MateriAndJFragment();
        } else {
            return new LatihanAndJFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
