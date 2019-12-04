package org.d3ifcool.sicoding.awal.login.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.awal.login.login.LoginActivity;

import java.util.HashMap;


public class RegisterActivity extends AppCompatActivity {
    private TextInputLayout nama, email, password;
    private Button regist;
    private ProgressDialog mLoading;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference reference;
    String namaUser;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference().child("User");
        nama = findViewById(R.id.tV_nama);
        email = findViewById(R.id.tV_email);
        password = findViewById(R.id.tV_password);
        regist = findViewById(R.id.btn_Regist);

        mLoading = new ProgressDialog(this);
        mLoading.setMessage("Harap Tunggu");


        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namaUser = nama.getEditText().getText().toString().trim();
                String emailUser = email.getEditText().getText().toString().trim();
                String passwordUser = password.getEditText().getText().toString().trim();

                if (namaUser.isEmpty()) {
                    nama.setError("Masukan Nama Anda");
                    nama.setFocusable(true);
                } else if (emailUser.isEmpty()) {
                    email.setError("Masukkan Email Anda");
                    email.setFocusable(true);
                } else if (!emailUser.matches(emailPattern)) {
                    email.setError("Masukan Email yang Valid");
                    email.setFocusable(true);
                } else if (passwordUser.isEmpty()) {
                    password.setError("Masukan Password Terlebih Dahulu");
                    password.setFocusable(true);
                } else if (passwordUser.length() < 8) {
                    password.setError("Masukan Password Minimal 8");
                    password.setFocusable(true);
                } else {
                    registerUser(emailUser, passwordUser);

                }
            }
        });

    }

    private void registerUser(String emailUser, String passwordUser) {
//        mLoading.show();

        firebaseAuth.createUserWithEmailAndPassword(emailUser, passwordUser)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            mLoading.dismiss();
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Toast.makeText(RegisterActivity.this, "Berhasil Daftar dengan email \n"+user.getEmail(), Toast.LENGTH_SHORT).show();
                            HashMap hashMap = new HashMap();
                            String emailmap = user.getEmail();
                            String uid = user.getUid();

                            hashMap.put("email", emailmap);
                            hashMap.put("uid", uid);
                            hashMap.put("nama", namaUser);
                            hashMap.put("hobby", "");
                            hashMap.put("motto", "");
                            hashMap.put("ketrampilan", "");
                            hashMap.put("deskripsi", "");
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference reference = database.getReference("User");
                            reference.child(uid).setValue(hashMap);
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            mLoading.dismiss();
                            Toast.makeText(RegisterActivity.this, "Otentikasi Gagal.",
                                    Toast.LENGTH_SHORT).show();

                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                mLoading.dismiss();
                Toast.makeText(RegisterActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }


}
