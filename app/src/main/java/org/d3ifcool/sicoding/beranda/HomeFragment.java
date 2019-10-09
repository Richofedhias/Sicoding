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
    DatabaseAdapter DBAdapter;
    AndroidAdapter AndAdapter;
    ArrayList<BerandaList> listWeb = new ArrayList<>();
    ArrayList<DatabaseList> listDatabase = new ArrayList<>();
    ArrayList<AndroidList> listAndroid = new ArrayList<>();

    public HomeFragment() {
        //Web
        listWeb.add(new BerandaList("HTML",R.drawable.ic_html));
        listWeb.add(new BerandaList("CSS",R.drawable.ic_css));
        listWeb.add(new BerandaList("PHP",R.drawable.ic_php));
        listWeb.add(new BerandaList("Jquery",R.drawable.ic_jquery));
        listWeb.add(new BerandaList("JavaScript",R.drawable.ic_javascript));
        listWeb.add(new BerandaList("Bootstrap",R.drawable.ic_bootstrap));

        //Database
        listDatabase.add(new DatabaseList("JSON", R.drawable.ic_json));
        listDatabase.add(new DatabaseList("Firebase", R.drawable.ic_firebase));
        listDatabase.add(new DatabaseList("MySQL", R.drawable.ic_mysql));

        //
        listAndroid.add(new AndroidList("Java",R.drawable.ic_androidjava));
        listAndroid.add(new AndroidList("Kotlin",R.drawable.ic_kotlin));
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
        LinearLayoutManager lm1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager lm2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rV_listWeb.setLayoutManager(lm);
        rV_listDatabase.setLayoutManager(lm1);
        rV_listAndroid.setLayoutManager(lm2);
        adapter = new BerandaAdapter(listWeb,getContext());
        DBAdapter = new DatabaseAdapter(getContext(),listDatabase);
        AndAdapter = new AndroidAdapter(getContext(),listAndroid);
        rV_listWeb.setAdapter(adapter);
        rV_listDatabase.setAdapter(DBAdapter);
        rV_listAndroid.setAdapter(AndAdapter);

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