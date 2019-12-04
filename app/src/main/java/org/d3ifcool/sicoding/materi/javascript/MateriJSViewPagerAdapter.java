package org.d3ifcool.sicoding.materi.javascript;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.d3ifcool.sicoding.materi.javascript.latihan.LatihanJSFragment;
import org.d3ifcool.sicoding.materi.javascript.materi.MateriJSFragment;

public class MateriJSViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;

    public MateriJSViewPagerAdapter(Context mContext, @NonNull FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MateriJSFragment();
        } else{
            return new LatihanJSFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
