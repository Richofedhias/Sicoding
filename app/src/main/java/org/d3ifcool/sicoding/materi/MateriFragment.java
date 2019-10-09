package org.d3ifcool.sicoding.materi;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.beranda.BerandaAdapter;
import org.d3ifcool.sicoding.beranda.BerandaList;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MateriFragment extends Fragment {

    RecyclerView rv_list;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    private ArrayList<MenuMateri> data = new ArrayList<>();

    public MateriFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_materi, container, false);
        rv_list = v.findViewById(R.id.rV_materi);
        rv_list.setHasFixedSize(true);
        rv_list.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("web");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<MenuMateri> options =
                new FirebaseRecyclerOptions.Builder<MenuMateri>()
                        .setQuery(reference, MenuMateri.class)
                        .build();

        FirebaseRecyclerAdapter firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<MenuMateri, MenuMateriAdapter>(options) {

                    @Override
                    protected void onBindViewHolder(@NonNull MenuMateriAdapter menuMateriAdapter, int i, @NonNull MenuMateri menuMateri) {
                        menuMateriAdapter.setDetail(getActivity().getApplicationContext(), menuMateri.getJudul(), menuMateri.getDesk());
                    }

                    @Override
                    public MenuMateriAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_menu_materi_item, parent, false);
                        MenuMateriAdapter menuMateriAdapter = new MenuMateriAdapter(parent);

                        menuMateriAdapter.setOnClickListener(new MenuMateriAdapter.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                TextView mTitle_tv = view.findViewById(R.id.tv_judulMateri) ;
                                TextView mDesck_tv = view.findViewById(R.id.tv_deskMateri);

                                //mengambil data
                                String mTitle = mTitle_tv.getText().toString();
                                String mDesk = mDesck_tv.getText().toString();

                                //melewati data ini ke activity baru
                                Intent intent = new Intent(view.getContext(), DetailMateriActivity.class);
                                intent.putExtra("title" , mTitle);
                                intent.putExtra("deskripsi", mDesk);
                                startActivity(intent);
                            }

                            @Override
                            public void onItemLongClick(View view, int position) {

                            }
                        });
                        return menuMateriAdapter;
                    }
                };

        rv_list.setAdapter(firebaseRecyclerAdapter);
    }
}
