package org.d3ifcool.sicoding.materi.javascript.materi;


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
import org.d3ifcool.sicoding.materi.JSON.materi.DataMateriJSON;
import org.d3ifcool.sicoding.materi.JSON.materi.MateriJSONAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MateriJSFragment extends Fragment {

    FirebaseDatabase firebaseDatabase;
    StorageReference storageRef;
    RecyclerView rv_list;
    DatabaseReference reference;
    MateriJSAdapter adapter;
    View v;
    ProgressDialog pg;

    ArrayList<DataMateriJS> data = new ArrayList<>();


    public MateriJSFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (v == null) {
            v = inflater.inflate(R.layout.fragment_materi_j, container, false);
            rv_list = v.findViewById(R.id.rV_materi_js);
            rv_list.setHasFixedSize(true);
            rv_list.setLayoutManager(new LinearLayoutManager(getContext()));
            pg = new ProgressDialog(getActivity());
            pg.setMessage("Tunggu..");

            firebaseDatabase = FirebaseDatabase.getInstance();
            reference = firebaseDatabase.getReference();
            storageRef = FirebaseStorage.getInstance().getReference();

            init();
        }
        return v;
    }

    private void init() {
        Query query = reference.child("js").child("materi");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    DataMateriJS materii = new DataMateriJS();
                    materii.setJudul(snapshot.child("judul_materi_js").getValue().toString());
                    materii.setDesk(snapshot.child("isi_materi_js").getValue().toString());

                    data.add(materii);

                    data.add(materii);
                    if (materii == null){
                        pg.show();
                    }else{
                        pg.dismiss();
                    }
                }
                adapter = new MateriJSAdapter(getContext(), data);
                rv_list.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
