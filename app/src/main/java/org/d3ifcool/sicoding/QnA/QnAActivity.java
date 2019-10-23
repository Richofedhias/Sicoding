package org.d3ifcool.sicoding.QnA;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.d3ifcool.sicoding.KategoriKuisActivity;
import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.beranda.BerandaActivity;
import org.d3ifcool.sicoding.materi.DataMateri;
import org.d3ifcool.sicoding.materi.MenuMateri;
import org.d3ifcool.sicoding.materi.MenuMateriAdapter;

import java.util.ArrayList;

public class QnAActivity extends AppCompatActivity {

    RecyclerView rV_list;
    QnAAdapter adapter;
    ArrayList<QnAList> list = new ArrayList<>();
    FloatingActionButton fab1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qn_a);

        rV_list = findViewById(R.id.rV_QnA);
        rV_list.setHasFixedSize(true);
        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rV_list.setLayoutManager(lm);
        adapter = new QnAAdapter(list);
        rV_list.setAdapter(adapter);
        isiQnA();
    }

    public void floatingbutton() {
        fab1 = findViewById(R.id.fabpost);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QnAActivity.this, NewPostActivity.class);
                startActivity(intent);
            }
        });
    }

    public void isiQnA(){
        list.add(new QnAList("erbina","bagaimana cara membuat recycleview pada android?",R.drawable.logo));
        list.add(new QnAList("erbina","bagaimana cara membuat recycleview pada android?",R.drawable.logo));
        list.add(new QnAList("erbina","bagaimana cara membuat recycleview pada android?",R.drawable.logo));
    }
}
