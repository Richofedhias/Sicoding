package org.d3ifcool.sicoding.materi;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.d3ifcool.sicoding.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContohFragment extends Fragment {

    RecyclerView rV_list;
    LatihanAdapter adapter;
    ArrayList<MenuMateri> list = new ArrayList<>();

    public ContohFragment() {
        // Required empty public constructor
//        list.add(new MenuMateri("Mengatur Tag Pada HTML"));
//        list.add(new MenuMateri("Membuat Title Pada HTML"));
//        list.add(new MenuMateri("Mengatur Heading Pada HTML"));
//        list.add(new MenuMateri("Membuat Format Text Pada HTML"));
//        list.add(new MenuMateri("Membuat Paragraf Pada HTML"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_contoh, container, false);
        rV_list = v.findViewById(R.id.rV_contoh);

        list.addAll(DataLatihan.getListData());
        LinearLayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rV_list.setLayoutManager(lm);
        adapter = new LatihanAdapter(list);
        rV_list.setAdapter(adapter);
        return v;
    }

}
