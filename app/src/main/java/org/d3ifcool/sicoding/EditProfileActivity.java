package org.d3ifcool.sicoding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.d3ifcool.sicoding.awal.login.login.LoginActivity;

import java.util.HashMap;

public class EditProfileActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseUser user;
    private TextInputLayout nama,tentang,et_motto,eT_hobi;
    private ImageView profile;
    private Button simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User");
        nama = findViewById(R.id.eT_editNama);
        tentang = findViewById(R.id.eT_editTentangsaya);
        et_motto = findViewById(R.id.eT_editMotto);
        eT_hobi = findViewById(R.id.eT_editHobi);
        simpan = findViewById(R.id.btn_simpan);
        profile = findViewById(R.id.iv_editProfile);
        checkUser();

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaMap = nama.getEditText().getText().toString().trim();
                String tentangMap = tentang.getEditText().getText().toString().trim();
                String mottoMap = et_motto.getEditText().getText().toString().trim();
                String hobbiMap = eT_hobi.getEditText().getText().toString().trim();

                HashMap<String, Object> result = new HashMap<>();
                String emailmap = user.getEmail();
                String uid = user.getUid();


                result.put("email", emailmap);
                result.put("uid", uid);
                result.put("nama",namaMap);
                result.put("deskripsi",tentangMap);
                result.put("motto",mottoMap);
                result.put("hobby",hobbiMap);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("User");
                reference.child(user.getUid()).setValue(result);

                startActivity(new Intent(EditProfileActivity.this, ProfileActivity.class));
            }
        });


    }


    private void checkUser() {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            Query query = databaseReference.orderByChild("email").equalTo(user.getEmail());
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String name = "" + ds.child("nama").getValue();
                        String deskripsi = "" + ds.child("deskripsi").getValue();
                        String motto = "" + ds.child("motto").getValue();
                        String hobby = "" + ds.child("hobby").getValue();
                        String image = "" + ds.child("image").getValue();

                        nama.getEditText().setText(name);
                        tentang.getEditText().setText(deskripsi);
                        et_motto.getEditText().setText(motto);
                        eT_hobi.getEditText().setText(hobby);

                    try {
                        Picasso.get().load(image).into(profile);
                    }
                    catch (Exception e){
                        Picasso.get().load(R.drawable.ic_launcher_background).into(profile);
                    }
//
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}
