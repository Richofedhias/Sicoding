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

import org.d3ifcool.sicoding.beranda.BerandaActivity;


public class LoginActivity extends AppCompatActivity {
    private Button registrasi, login;
    private EditText email, password;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog mLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.eT_loginEmail);
        password = findViewById(R.id.eT_loginPassword);

        mLoading = new ProgressDialog(this);
        mLoading.setMessage("Harap Tungguu");

        firebaseAuth = FirebaseAuth.getInstance();
//        if (firebaseAuth.getCurrentUser() != null) {
//            startActivity(new Intent(LoginActivity.this, BerandaActivity.class));
//        }

        registrasi = findViewById(R.id.btn_registrasi);
        registrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        login = findViewById(R.id.btn_Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_user = email.getText().toString();
                final String password_user = password.getText().toString();

                if (email_user.isEmpty()) {
                    email.setError("Masukan Email");
                    return;
                } else if (password_user.isEmpty()) {
                    password.setError("Masukan Password");
                    return;
                } else {
                    firebaseAuth.signInWithEmailAndPassword(email_user,password_user)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    mLoading.dismiss();
                                    if (!task.isSuccessful()) {
                                        // there was an error
                                        if (password_user.length() <= 8) {
                                            password.setError("Masukan Password minimal 8");
                                        } else {
                                            Toast.makeText(LoginActivity.this, "Gagal", Toast.LENGTH_LONG).show();
                                        }
                                    } else {
                                        Intent intent = new Intent(LoginActivity.this, BerandaActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
                }
            }
        });
    }
}
