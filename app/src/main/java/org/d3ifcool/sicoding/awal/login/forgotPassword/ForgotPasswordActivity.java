package org.d3ifcool.sicoding.awal.login.forgotPassword;

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
import com.google.firebase.auth.FirebaseAuth;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.awal.login.login.LoginActivity;

public class ForgotPasswordActivity extends AppCompatActivity {
    TextInputLayout email;
    Button kirim, hapus;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.eT_forgotPassword);
        kirim = findViewById(R.id.btnkirim);
        hapus = findViewById(R.id.btn_hapus);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);



        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                String email_user = email.getEditText().getText().toString().trim();
                forgetPassword(email_user);



            }
        });

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email.getEditText().setText("");
            }
        });
    }

    private void forgetPassword(String email_user) {
        progressDialog.setMessage("Harap Tunggu..");
        progressDialog.show();
        firebaseAuth.sendPasswordResetEmail(email_user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(ForgotPasswordActivity.this, "Email Dikirim", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ForgotPasswordActivity.this, LoginActivity.class));
                            finish();
                        } else {
                            Toast.makeText(ForgotPasswordActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(ForgotPasswordActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
