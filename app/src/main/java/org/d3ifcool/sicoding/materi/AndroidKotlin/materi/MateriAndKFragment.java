package org.d3ifcool.sicoding.materi.AndroidKotlin.materi;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.materi.AndroidJava.materi.DataMateriAndJ;
import org.d3ifcool.sicoding.materi.AndroidJava.materi.MateriAndJAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MateriAndKFragment extends Fragment {
    FirebaseDatabase firebaseDatabase;
    StorageReference storageRef;
    RecyclerView rv_list;
    DatabaseReference reference;
    MateriAndKAdapter adapter;
    View v;
    ProgressDialog pg;

    ArrayList<DataMateriAndK> data = new ArrayList<>();

    public MateriAndKFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (v == null) {
            v = inflater.inflate(R.layout.fragment_materi_and_k, container, false);
            rv_list = v.findViewById(R.id.rV_materi_kotlin);
            rv_list.setHasFixedSize(true);
            rv_list.setLayoutManager(new LinearLayoutManager(getContext()));

            firebaseDatabase = FirebaseDatabase.getInstance();
            reference = firebaseDatabase.getReference();
            storageRef = FirebaseStorage.getInstance().getReference();
            pg = new ProgressDialog(getActivity());
            pg.setMessage("Tunggu...");
            pg.show();

            init();
        }
        return v;
    }

    private void init() {
        Query query = reference.child("kotlin").child("materi");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    DataMateriAndK materii = new DataMateriAndK();
                    materii.setJudul(snapshot.child("judul_materi_kotlin").getValue().toString());
                    materii.setDesk(snapshot.child("isi_materi_kotlin").getValue().toString());

                    data.add(materii);
                    if (materii == null){
                        pg.show();
                    }else{
                        pg.dismiss();
                    }
                }
                adapter = new MateriAndKAdapter(getContext(), data);
                rv_list.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
