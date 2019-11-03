package org.d3ifcool.sicoding.awal.login.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.d3ifcool.sicoding.ProfileActivity;
import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.awal.login.forgotPassword.ForgotPasswordActivity;
import org.d3ifcool.sicoding.awal.login.register.RegisterActivity;
import org.d3ifcool.sicoding.beranda.BerandaActivity;


public class LoginActivity extends AppCompatActivity {
    private Button login;
    private TextInputLayout email, password;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog mLoading;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private CheckBox remember;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.eT_loginEmail);
        password = findViewById(R.id.eT_loginPassword);
        remember = findViewById(R.id.cb_remember);
        login = findViewById(R.id.btn_Login);
        mLoading = new ProgressDialog(this);
        mLoading.setMessage("Harap Tungguu");
        firebaseAuth = FirebaseAuth.getInstance();
//        if (firebaseAuth.getCurrentUser() != null) {
//            startActivity(new Intent(LoginActivity.this, BerandaActivity.class));
////        }
 //Pengerjaan Remember

//        SharedPreferences sharedPreferences = getSharedPreferences("checkbox",MODE_PRIVATE);
//        String checkbox = sharedPreferences.getString("remember","");
//
//        if (checkbox.equals("true")){
////            startActivity(new Intent(LoginActivity.this, BerandaActivity.class));
//        }else if (checkbox.equals("false")){
//
//        }


        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    SharedPreferences sharedPreferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("remember","true");
                    editor.apply();
                }else if (!compoundButton.isChecked()){
                    SharedPreferences sharedPreferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("remember","false");
                }
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_user = email.getEditText().getText().toString();
                final String password_user = password.getEditText().getText().toString();

                if (email_user.isEmpty()) {
                    email.setError("Masukan Email");
                    email.setFocusable(true);
                } else if (password_user.isEmpty()) {
                    password.setError("Masukan Password");
                    password.setFocusable(true);
                } else if (!email_user.matches(emailPattern)) {
                    email.setError("Masukan Email yang Valid");
                    email.setFocusable(true);
                }else{
                    loginUser(email_user,password_user);
                }
            }
        });
    }

    private void loginUser(String email_user, String password_user) {
        mLoading.show();
        firebaseAuth.signInWithEmailAndPassword(email_user, password_user)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            mLoading.dismiss();
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            startActivity(new Intent(LoginActivity.this,BerandaActivity.class));
                            finish();
                        } else {
                            mLoading.dismiss();
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                mLoading.dismiss();
                Toast.makeText(LoginActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    public void LupaPassword(View view) {
        startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));

    }

    public void Register(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }
}
