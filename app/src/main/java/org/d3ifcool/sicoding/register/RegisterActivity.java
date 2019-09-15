package org.d3ifcool.sicoding.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.RestApi.ApiService;
import org.d3ifcool.sicoding.RestApi.UtilsApi;
import org.d3ifcool.sicoding.login.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity {
    private EditText nama;
    private EditText email;
    private EditText password;
    private Button regist;
    private ProgressDialog mLoading;
    private Context mContext;
    private ApiService mApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nama = findViewById(R.id.tV_nama);
        email = findViewById(R.id.tV_email);
        password = findViewById(R.id.tV_password);
        regist = findViewById(R.id.btn_Regist);
        mContext = this;
        addButton();
        mLoading = new ProgressDialog(this);
        mLoading.setMessage("Harap Tungguu");

    }


    private void addButton() {

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama_user = nama.getText().toString().trim();
                String email_user = email.getText().toString().trim();
                String password_user = password.getText().toString().trim();
                if (nama_user.isEmpty()) {
                    nama.setError("Masukan Nama Terlebih dahulu");
                } else if (email_user.isEmpty()) {
                    email.setError("Masukan Email Terlebih dahulu");
                } else if (password_user.isEmpty()) {
                    password.setError("Masukan Password Terlebih dahulu");
                }else if (password_user.length() <=8){
                    password.setError("Password Minimal 8 kata");
                } else {

//                    mLoading = ProgressDialog.show(RegisterActivity.this, "", "Harap Tunggu..", false, false);
                    insertData(nama_user, email_user, password_user);
//                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                    startActivity(intent);
                }

            }
        });
    }

    private void insertData(final String nama_user, final String email_user, final String password_user) {

        mLoading.show();
        mApiService = UtilsApi.getAPIService().create(ApiService.class);
        Call<User> call = mApiService.registerRequest(nama_user, email_user, password_user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                mLoading.dismiss();

                if (response.isSuccessful() && response.body() != null) {
                    Boolean success = response.body().getSuccess();
                    if (success) {
                        Toast.makeText(RegisterActivity.this,
                                response.body().getMessage(),
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this,
                            response.body().getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                mLoading.dismiss();
//                Toast.makeText(RegisterActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}
