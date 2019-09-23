package org.d3ifcool.sicoding.beranda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.d3ifcool.sicoding.R;

public class HomeFragment extends Fragment {
    ViewFlipper vF_slideShow;
    RecyclerView rV_list;

    public HomeFragment() {
//        rV_list.setHasFixedSize(true);
//        RecyclerView.LayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        rV_list.setLayoutManager(lm);
//        adapter = new BerandaAdapter(list);
//        rV_list.setAdapter(adapter);
//
//        list.add(new IsiBeranda("Boostrap",R.drawable.logo));
//        list.add(new IsiBeranda("Boostrap",R.drawable.logo));
//        list.add(new IsiBeranda("Boostrap",R.drawable.logo));
//        list.add(new IsiBeranda("Boostrap",R.drawable.logo));

        //SlideShow
//        int images[] = {R.drawable.slide_1, R.drawable.slide_2, R.drawable.slide_3};
//        for (int i = 0; i < images.length; i++) {
//            slideShow(images[i]);
//        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        return null;
    }

//    private void slideShow(int image) {
//        ImageView imageView = new ImageView(this);
//        imageView.setBackgroundResource(image);
//        vF_slideShow.addView(imageView);
//        vF_slideShow.setFlipInterval(4000);
//        vF_slideShow.setAutoStart(true);
//
//        vF_slideShow.setInAnimation(this,android.R.anim.slide_in_left);
//        vF_slideShow.setOutAnimation(this,android.R.anim.slide_out_right);
//    }
}