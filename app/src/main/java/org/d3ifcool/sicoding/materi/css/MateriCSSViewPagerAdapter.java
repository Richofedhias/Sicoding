package org.d3ifcool.sicoding.materi.css;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.d3ifcool.sicoding.materi.css.latihanCSS.LatihanCSSFragment;
import org.d3ifcool.sicoding.materi.css.materiCSS.MateriCSSFragment;

public class MateriCSSViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;

    public MateriCSSViewPagerAdapter(Context mContext, @NonNull FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MateriCSSFragment();
        } else{
            return new LatihanCSSFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
