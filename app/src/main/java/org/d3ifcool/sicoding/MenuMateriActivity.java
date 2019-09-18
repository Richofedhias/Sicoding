package org.d3ifcool.sicoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuMateriActivity extends AppCompatActivity {

    private RecyclerView rV_list ;
    private MenuMateriAdapter adapter;
    private TextView tV_namaUser ;
    private TextView tV_namaLang;
    private ArrayList<MenuMateri> menuMateriList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_materi);

        rV_list = findViewById(R.id.rV_menuMateri);
        tV_namaUser = findViewById(R.id.tV_namaUser);
        tV_namaLang = findViewById(R.id.tV_namaLang);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rV_list.setLayoutManager(lm);

        adapter = new MenuMateriAdapter(menuMateriList);
        rV_list.setAdapter(adapter);
    }

    public void JudulMateri() {
        menuMateriList.add(new MenuMateri("Pengenalan HTML"));
        menuMateriList.add(new MenuMateri("Sejarah HTML"));
        menuMateriList.add(new MenuMateri("Pengenalan Tag Tag Pada HTML"));
        menuMateriList.add(new MenuMateri("Pengenalan Element Pada HTML"));
        menuMateriList.add(new MenuMateri("Pengenalan Atribut Pada HTML"));
        menuMateriList.add(new MenuMateri("Format Text Pada HTML"));
        menuMateriList.add(new MenuMateri("Membuat Paragraf Pada HTML"));
        menuMateriList.add(new MenuMateri("Membuat Table Pada HTML"));
        menuMateriList.add(new MenuMateri("Membuat Hyperlink Pada HTML"));
    }
}
