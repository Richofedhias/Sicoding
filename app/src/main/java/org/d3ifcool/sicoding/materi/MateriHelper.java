package org.d3ifcool.sicoding.materi;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MateriHelper {

    DatabaseReference databaseReference;
    Boolean saved = null;
    ArrayList<MenuMateri> menuMateris = new ArrayList<>();


    public MateriHelper(DatabaseReference databaseReference) {
        this.databaseReference = databaseReference;
    }

    public Boolean save(MenuMateri menuMateri) {
        if (menuMateri == null) {
            saved = false;
        } else {
            try {
                databaseReference = FirebaseDatabase.getInstance().getReference("web").child("1");
//                databaseReference.child("1").setValue(menuMateri);
                saved = true;
            } catch (DatabaseException e) {
                e.printStackTrace();
                saved = true;
            }
        }
        return saved;
    }

    private void fetchData(DataSnapshot snapshot) {
        menuMateris.clear();
        for (DataSnapshot dataSnapshot : snapshot.getChildren()){
            MenuMateri materis = dataSnapshot.getValue(MenuMateri.class);
            menuMateris.add(materis);
        }
    }

    public ArrayList<MenuMateri> retrieve(){
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return menuMateris;
    }
}