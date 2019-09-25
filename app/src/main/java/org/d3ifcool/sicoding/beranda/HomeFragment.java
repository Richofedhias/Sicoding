package org.d3ifcool.sicoding.beranda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.d3ifcool.sicoding.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ViewFlipper vF_slideShow;
    RecyclerView rV_listWeb, rV_listDatabase, rV_listAndroid;
    BerandaAdapter adapter;
    ArrayList<BerandaList> listWeb = new ArrayList<>();
    ArrayList<BerandaList> listDatabase = new ArrayList<>();
    ArrayList<BerandaList> listAndroid = new ArrayList<>();

    public HomeFragment() {
        //Web
        listWeb.add(new BerandaList("HTML",R.drawable.ic_html));
        listWeb.add(new BerandaList("CSS",R.drawable.ic_css));
        listWeb.add(new BerandaList("PHP",R.drawable.ic_php));
        listWeb.add(new BerandaList("Jquery",R.drawable.ic_jquery));
        listWeb.add(new BerandaList("JavaScript",R.drawable.ic_javascript));
        listWeb.add(new BerandaList("Bootstrap",R.drawable.ic_bootstrap));

        //Database
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        rV_listWeb = v.findViewById(R.id.rV_listWeb);
        rV_listDatabase = v.findViewById(R.id.rV_listDatabase);
        rV_listAndroid = v.findViewById(R.id.rV_listAndroid);

        //SlideShow
//        int images[] = {R.drawable.slide_1, R.drawable.slide_2, R.drawable.slide_3};
//        for (int i = 0; i < images.length; i++) {
//            slideShow(images[i]);
//        }

        rV_listWeb.setHasFixedSize(true);
        rV_listDatabase.setHasFixedSize(true);
        rV_listAndroid.setHasFixedSize(true);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rV_listWeb.setLayoutManager(lm);
//        rV_listDatabase.setLayoutManager(lm);
//        rV_listAndroid.setLayoutManager(lm);
        adapter = new BerandaAdapter(listWeb,getContext());
        adapter = new BerandaAdapter(listDatabase,getContext());
        adapter = new BerandaAdapter(listAndroid,getContext());
        rV_listWeb.setAdapter(adapter);
        rV_listDatabase.setAdapter(adapter);
        rV_listAndroid.setAdapter(adapter);
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