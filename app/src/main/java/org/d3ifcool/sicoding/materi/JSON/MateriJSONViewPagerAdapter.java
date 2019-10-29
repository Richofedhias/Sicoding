package org.d3ifcool.sicoding.materi.JSON;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.d3ifcool.sicoding.materi.JSON.latihan.LatihanJSONFragment;
import org.d3ifcool.sicoding.materi.JSON.materi.MateriJSONFragment;

public class MateriJSONViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;

    public MateriJSONViewPagerAdapter(Context mContext, @NonNull FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MateriJSONFragment();
        } else {
            return new LatihanJSONFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
