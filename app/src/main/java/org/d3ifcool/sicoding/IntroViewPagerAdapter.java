package org.d3ifcool.sicoding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class IntroViewPagerAdapter extends PagerAdapter {

    Context mContext;
    List<ScreenItem> mListScreen;

    public IntroViewPagerAdapter(Context mContext, List<ScreenItem> mListScreen) {
        this.mContext = mContext;
        this.mListScreen = mListScreen;
    }

    @Override
    public int getCount() {
        return mListScreen.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.layout_screen, null);

        ImageView imageScreen = v.findViewById(R.id.iV_imageScreen);
        TextView title = v.findViewById(R.id.tV_title);
        TextView subtitle = v.findViewById(R.id.tV_desc);

        title.setText(mListScreen.get(position).getTitle());
        subtitle.setText(mListScreen.get(position).getDesc());
        imageScreen.setImageResource(mListScreen.get(position).getScreenImg());

        container.addView(v);

        return v;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
