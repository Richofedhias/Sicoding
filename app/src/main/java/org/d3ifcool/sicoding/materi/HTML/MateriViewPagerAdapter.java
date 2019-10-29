package org.d3ifcool.sicoding.materi.HTML;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.d3ifcool.sicoding.materi.HTML.latihanHTML.ContohFragment;
import org.d3ifcool.sicoding.materi.HTML.materiHTML.MateriFragment;

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
