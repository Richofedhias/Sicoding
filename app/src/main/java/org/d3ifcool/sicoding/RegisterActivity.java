package org.d3ifcool.sicoding;

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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterActivity extends AppCompatActivity {
    private EditText nama;
    private EditText email;
    private EditText password;
    private Button regist;
    private ProgressDialog mLoading;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth = FirebaseAuth.getInstance();
        nama = findViewById(R.id.tV_nama);
        email = findViewById(R.id.tV_email);
        password = findViewById(R.id.tV_password);
        regist = findViewById(R.id.btn_Regist);
        mLoading = new ProgressDialog(this);
        mLoading.setMessage("Harap Tungguu");

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaUser = nama.getText().toString().trim();
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
                                    Toast.makeText(RegisterActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                    mLoading.show();
                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(RegisterActivity.this, "Authentication failed." + task.getException(),
                                                Toast.LENGTH_SHORT).show();
                                    } else {
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
