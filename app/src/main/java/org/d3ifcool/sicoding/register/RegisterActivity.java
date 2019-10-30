package org.d3ifcool.sicoding.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.login.LoginActivity;

import java.util.HashMap;


public class RegisterActivity extends AppCompatActivity {
    private EditText nama;
    private EditText email;
    private EditText password;
    private Button regist;
    private ProgressDialog mLoading;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference reference;
    String namaUser;




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
        final ImageView showPass = findViewById(R.id.iv_showPass);
        final ImageView hidePass = findViewById(R.id.iv_hidePass);
        showPass.setVisibility(View.GONE);

        hidePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                showPass.setVisibility(View.VISIBLE);
                hidePass.setVisibility(View.GONE);
            }
        });

        showPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                hidePass.setVisibility(View.VISIBLE);
                showPass.setVisibility(View.GONE);
            }
        });



        mLoading = new ProgressDialog(this);
        mLoading.setMessage("Harap Tungguu");


        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 namaUser = nama.getText().toString().trim();
                String emailUser = email.getText().toString().trim();
                String passwordUser = password.getText().toString().trim();

                if (namaUser.isEmpty()) {
                    nama.setError("Masukan Nama Anda");
                    return;
                } else if (emailUser.isEmpty()) {
                    email.setError("Masukkan Email Anda");
                    return;
                } else if (passwordUser.isEmpty()) {
                    password.setError("Masukkan Password");
                    return;
                } else if (passwordUser.length() <= 8) {
                    password.setError("Masukan Password Minimal 8");
                    return;
                } else {
                    mLoading.dismiss();

                    firebaseAuth.createUserWithEmailAndPassword(emailUser, passwordUser)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Toast.makeText(RegisterActivity.this, " " + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                    mLoading.show();
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(RegisterActivity.this, "Gagal Buat Akun" + task.getException(),
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                            FirebaseUser user = firebaseAuth.getCurrentUser();
                                        Toast.makeText(RegisterActivity.this, "Berhasil Buat Akun", Toast.LENGTH_SHORT).show();
                                        finish();

                            String emailmap = user.getEmail();
                            String uid = user.getUid();

                            HashMap hashMap = new HashMap();
////Masih Proses
                            hashMap.put("email", emailmap);
                            hashMap.put("uid", uid);
                            hashMap.put("nama", namaUser);
                            hashMap.put("hobby", "");
                            hashMap.put("motto", "");
                            hashMap.put("ketrampilan", "");
                            hashMap.put("deskripsi", "");
                            hashMap.put("image", "");
                            hashMap.put("cover", "");
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference reference = database.getReference("User");
                            reference.child(uid).setValue(hashMap);
                                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                        finish();
                                    }
                                }
                            });

                }
            }
        });

    }


}
