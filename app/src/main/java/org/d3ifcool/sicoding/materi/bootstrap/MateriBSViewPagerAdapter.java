package org.d3ifcool.sicoding.materi.bootstrap;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.d3ifcool.sicoding.materi.HTML.PraktekFragment;
import org.d3ifcool.sicoding.materi.bootstrap.latihan.LatihanBSFragment;
import org.d3ifcool.sicoding.materi.bootstrap.materi.MateriBSFragment;
import org.d3ifcool.sicoding.materi.css.latihanCSS.LatihanCSSFragment;
import org.d3ifcool.sicoding.materi.css.materiCSS.MateriCSSFragment;

public class MateriBSViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;

    public MateriBSViewPagerAdapter(Context mContext, @NonNull FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MateriBSFragment();
        } else if (position == 1){
            return new LatihanBSFragment();
        } else {
            return new PraktekFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
