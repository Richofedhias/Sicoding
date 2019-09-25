package org.d3ifcool.sicoding.materi;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import org.d3ifcool.sicoding.R;

public class MateriViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;

    public MateriViewPagerAdapter(Context mContext, @NonNull FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MateriFragment();
        } else if (position == 1){
            return new ContohFragment();
        } else {
            return new PraktekFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
