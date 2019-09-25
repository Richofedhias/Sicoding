package org.d3ifcool.sicoding.materi;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.beranda.BerandaAdapter;
import org.d3ifcool.sicoding.beranda.BerandaList;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MateriFragment extends Fragment {

    RecyclerView rV_list;
    MenuMateriAdapter adapter;
    ArrayList<MenuMateri> list = new ArrayList<>();

    public MateriFragment() {
        // Required empty public constructor
        list.add(new MenuMateri("Pengenalan HTML"));
        list.add(new MenuMateri("Sejarah HTML"));
        list.add(new MenuMateri("Pengenalan Tag Pada HTML"));
        list.add(new MenuMateri("Pengenalan Element Pada HTML"));
        list.add(new MenuMateri("Pengenalan Atribut Pada HTML"));
        list.add(new MenuMateri("Materi Tentang Format Text Pada HTML"));
        list.add(new MenuMateri("Materi Membuat Paragraf Pada HTML"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_materi, container, false);
        rV_list = v.findViewById(R.id.rV_materi);

        LinearLayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rV_list.setLayoutManager(lm);
        adapter = new MenuMateriAdapter(list);
        rV_list.setAdapter(adapter);
        return v;
    }

}
