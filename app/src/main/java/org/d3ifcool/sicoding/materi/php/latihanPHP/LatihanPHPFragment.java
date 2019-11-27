package org.d3ifcool.sicoding.materi.php.latihanPHP;


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
import org.d3ifcool.sicoding.materi.HTML.latihanHTML.LatihanAdapter;
import org.d3ifcool.sicoding.materi.HTML.latihanHTML.MenuContoh;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LatihanPHPFragment extends Fragment {
    RecyclerView rV_list;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference ref;
    StorageReference storageRef;
    LatihanPHPAdapter adapter;
    ArrayList<DataLatihanPHP> list = new ArrayList<>();


    public LatihanPHPFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_latihan_ph, container, false);
        rV_list = v.findViewById(R.id.rV_contoh_php);
        rV_list.setHasFixedSize(true);

        rV_list.setLayoutManager(new LinearLayoutManager(getContext()));

        firebaseDatabase = FirebaseDatabase.getInstance();
        ref = firebaseDatabase.getReference();
        storageRef = FirebaseStorage.getInstance().getReference();

        init();
        return v;
    }

    public void init() {
        Query query = ref.child("php").child("latihan");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    DataLatihanPHP contoh = new DataLatihanPHP();
                    contoh.setImages(snapshot.child("gambar").getValue().toString());
                    contoh.setJudul(snapshot.child("judul_latihan_php").getValue().toString());
                    contoh.setDesk(snapshot.child("isi_latihan_php").getValue().toString());

                    list.add(contoh);
                }
                adapter = new LatihanPHPAdapter(list, getContext());
                rV_list.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
