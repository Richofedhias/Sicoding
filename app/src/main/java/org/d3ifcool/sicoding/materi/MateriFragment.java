package org.d3ifcool.sicoding.materi;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.d3ifcool.sicoding.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MateriFragment extends Fragment {


    public MateriFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_materi, container, false);
        return v;
    }

}
