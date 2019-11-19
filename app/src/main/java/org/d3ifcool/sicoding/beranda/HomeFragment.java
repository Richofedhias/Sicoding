package org.d3ifcool.sicoding.beranda;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.d3ifcool.sicoding.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    SliderView sliderView;
    RecyclerView rV_listWeb, rV_listDatabase, rV_listAndroid;
    BerandaAdapter adapter;
    DatabaseAdapter DBAdapter;
    AndroidAdapter AndAdapter;
    ArrayList<BerandaList> listWeb = new ArrayList<>();
    ArrayList<DatabaseList> listDatabase = new ArrayList<>();
    ArrayList<AndroidList> listAndroid = new ArrayList<>();
    View v;

    public HomeFragment() {
        //Web
        listWeb.add(new BerandaList("HTML",R.drawable.ic_html));
        listWeb.add(new BerandaList("CSS",R.drawable.ic_css));
        listWeb.add(new BerandaList("PHP",R.drawable.ic_php));
        listWeb.add(new BerandaList("JavaScript",R.drawable.ic_javascript));
        listWeb.add(new BerandaList("Bootstrap",R.drawable.ic_bootstrap));

        //Database
        listDatabase.add(new DatabaseList("JSON", R.drawable.ic_json));
        listDatabase.add(new DatabaseList("Firebase", R.drawable.ic_firebase));
        listDatabase.add(new DatabaseList("MySQL", R.drawable.ic_mysql));

        //Android
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
        sliderView = v.findViewById(R.id.imageSlider);

        final SliderAdapter slideAdapter = new SliderAdapter(getActivity().getApplicationContext());
        slideAdapter.setCount(2);

        sliderView.setSliderAdapter(slideAdapter);

        //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                sliderView.setCurrentPagePosition(position);
            }
        });

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
}