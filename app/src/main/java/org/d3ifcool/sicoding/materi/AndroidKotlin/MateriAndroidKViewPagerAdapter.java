package org.d3ifcool.sicoding.materi.AndroidKotlin;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.d3ifcool.sicoding.materi.AndroidJava.latihan.LatihanAndJFragment;
import org.d3ifcool.sicoding.materi.AndroidJava.materi.MateriAndJFragment;
import org.d3ifcool.sicoding.materi.AndroidKotlin.latihan.LatihanAndKFragment;
import org.d3ifcool.sicoding.materi.AndroidKotlin.materi.MateriAndKFragment;

public class MateriAndroidKViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;

    public MateriAndroidKViewPagerAdapter(Context mContext, @NonNull FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MateriAndKFragment();
        } else {
            return new LatihanAndKFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
