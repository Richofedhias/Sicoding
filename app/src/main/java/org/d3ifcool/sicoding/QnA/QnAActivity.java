package org.d3ifcool.sicoding.QnA;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.d3ifcool.sicoding.KategoriKuisActivity;
import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.beranda.BerandaActivity;
import org.d3ifcool.sicoding.materi.DataMateri;
import org.d3ifcool.sicoding.materi.MenuMateri;
import org.d3ifcool.sicoding.materi.MenuMateriAdapter;

import java.util.ArrayList;
import java.util.List;

public class QnAActivity extends AppCompatActivity {

    RecyclerView rV_list;
    QnAAdapter adapter;
    List<QnAList> list;
    FloatingActionButton fab1;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qn_a);
        firebaseAuth = FirebaseAuth.getInstance();
        rV_list = findViewById(R.id.rV_QnA);
        rV_list.setHasFixedSize(true);
        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        lm.setStackFromEnd(true);
        lm.setReverseLayout(true);
        list = new ArrayList<>();
        rV_list.setLayoutManager(lm);
//        adapter = new QnAAdapter(list);
//        rV_list.setAdapter(adapter);
        loadPosts();
        floatingbutton();
    }

    public void floatingbutton() {
        fab1 = findViewById(R.id.fabpost);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QnAActivity.this, NewPostActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void loadPosts() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Post");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    QnAList model = ds.getValue(QnAList.class);
                    list.add(model);
                    adapter = new QnAAdapter(QnAActivity.this, list);
                    rV_list.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void searchPost(final String searchQuery) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Post");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    QnAList model = ds.getValue(QnAList.class);
                    if (model.getmTitle().toLowerCase().contains(searchQuery.toLowerCase()) ||
                            model.getmDesc().toLowerCase().contains(searchQuery.toLowerCase())) {
                        list.add(model);
                    }
                    adapter = new QnAAdapter(QnAActivity.this, list);
                    rV_list.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_post, menu);
//
//        MenuItem item = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                if (!TextUtils.isEmpty(query)) {
//                    searchPost(query);
//                } else {
//                    loadPosts();
//                }
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                if (!TextUtils.isEmpty(newText)) {
//                    searchPost(newText);
//                } else {
//                    loadPosts();
//                }
//                return false;
//            }
//        });
//        return super.onCreateOptionsMenu(menu);
//    }
}
