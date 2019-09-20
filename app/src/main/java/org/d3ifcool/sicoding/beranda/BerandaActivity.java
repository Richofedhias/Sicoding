package org.d3ifcool.sicoding.beranda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import org.d3ifcool.sicoding.R;

import java.util.ArrayList;

public class BerandaActivity extends AppCompatActivity {
    ViewFlipper vF_slideShow;
    RecyclerView rV_list;
    BerandaAdapter adapter;
    ArrayList<IsiBeranda> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        vF_slideShow = findViewById(R.id.vF_slideshow);
        rV_list = findViewById(R.id.rV_listButton);

        //SlideShow
        int images[] = {R.drawable.slide_1, R.drawable.slide_2, R.drawable.slide_3};
        for (int i = 0; i < images.length; i++) {
            slideShow(images[i]);
        }

        //Button Bahasa Pemrograman
        rV_list.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rV_list.setLayoutManager(lm);
        adapter = new BerandaAdapter(list);
        rV_list.setAdapter(adapter);

        list.add(new IsiBeranda("Boostrap",R.drawable.logo));
        list.add(new IsiBeranda("Boostrap",R.drawable.logo));
        list.add(new IsiBeranda("Boostrap",R.drawable.logo));
        list.add(new IsiBeranda("Boostrap",R.drawable.logo));

    }

    private void slideShow(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        vF_slideShow.addView(imageView);
        vF_slideShow.setFlipInterval(4000);
        vF_slideShow.setAutoStart(true);

        vF_slideShow.setInAnimation(this,android.R.anim.slide_in_left);
        vF_slideShow.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}
