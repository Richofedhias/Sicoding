package org.d3ifcool.sicoding.beranda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.d3ifcool.sicoding.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ViewFlipper vF_slideShow;
    RecyclerView rV_list;
    BerandaAdapter adapter;
    ArrayList<BerandaList> list = new ArrayList<>();

    public HomeFragment() {
        list.add(new BerandaList("Boostrap",R.drawable.logo));
        list.add(new BerandaList("Boostrap",R.drawable.logo));
        list.add(new BerandaList("Boostrap",R.drawable.logo));
        list.add(new BerandaList("Boostrap",R.drawable.logo));
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        rV_list = v.findViewById(R.id.rV_listButton);

        //SlideShow
//        int images[] = {R.drawable.slide_1, R.drawable.slide_2, R.drawable.slide_3};
//        for (int i = 0; i < images.length; i++) {
//            slideShow(images[i]);
//        }

        rV_list.setHasFixedSize(true);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rV_list.setLayoutManager(lm);
        adapter = new BerandaAdapter(list,getContext());
        rV_list.setAdapter(adapter);
        return v;
    }

//    private void slideShow(int image) {
//        ImageView imageView = new ImageView(getContext());
//        imageView.setBackgroundResource(image);
//        vF_slideShow.addView(imageView);
//        vF_slideShow.setFlipInterval(4000);
//        vF_slideShow.setAutoStart(true);
//
//        vF_slideShow.setInAnimation(getActivity(),android.R.anim.slide_in_left);
//        vF_slideShow.setOutAnimation(getActivity(),android.R.anim.slide_out_right);
//    }
}