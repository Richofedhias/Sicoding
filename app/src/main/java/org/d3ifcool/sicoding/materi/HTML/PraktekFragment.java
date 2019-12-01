package org.d3ifcool.sicoding.materi.HTML;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.api.ApiService;
import org.d3ifcool.sicoding.api.Handler;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okio.BufferedSink;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PraktekFragment extends Fragment {

    WebView webView;
    Button btn_run;
    TextView hasil;
    View v;
    private String clientId = "6913d900cb629042374e30b3e43f286b"; //Replace with your client ID
    private String clientSecret = "13feb130ede2ba37716de2b96827dac5afd0231c7d423248615d08f2b01ae206"; //Replace with your client Secret
    private String script = "<?php echo 1;?>";
    private String language = "php";
    private String versionIndex = "0";

    public PraktekFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_praktek, container, false);
        webView = v.findViewById(R.id.testing);
        btn_run = v.findViewById(R.id.btn_run);
        hasil = v.findViewById(R.id.hasil_praktek);

        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

        // Tiga baris di bawah ini agar laman yang dimuat dapat
        // melakukan zoom.
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        // Baris di bawah untuk menambahkan scrollbar di dalam WebView-nya
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.jdoodle.com/online-java-compiler/");

        btn_run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mExecute();
            }
        });

        return v;
    }

    private void mExecute() {
        try {
            URL url = new URL("https://api.jdoodle.com/v1/execute");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            String input = "{\"clientId\": \"" + clientId + "\",\"clientSecret\":\"" + clientSecret + "\",\"script\":\"" + script +
                    "\",\"language\":\"" + language + "\",\"versionIndex\":\"" + versionIndex + "\"} ";

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();

            Log.d("APITEST", input.toString());

//            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
//                throw new RuntimeException("Please check your inputs : HTTP error code : "+ connection.getResponseCode());
//            }
//
//            BufferedReader bufferedReader;
//            bufferedReader = new BufferedReader(new InputStreamReader(
//                    (connection.getInputStream())));
//
//            String output;
//            while ((output = bufferedReader.readLine()) != null) {
//                System.out.println(output);
//
//            }
//
//            connection.disconnect();


        } catch (Exception e) {

        }
    }

//        btn_run.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                    script = testing.getText().toString();
//                ApiService apiService = new Handler().getRetrofitInstance();
////                apiService.execute()
//                Call<String> execute = apiService.execute("application/json", clientId, clientSecret, script, language, versionIndex);
//                Log.d("APITEST", "run");
//
//                execute.enqueue(new Callback<String>() {
//                    @Override
//                    public void onResponse(Call<String> call, Response<String> response) {
//                        Log.d("APITEST", call.request().body()+"");
//                        if(response.isSuccessful()){
//                            try {
//                                JSONObject responseJson = new JSONObject(response.message());
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//
//                        }else{
//                            try {
//
//                                Log.d("APITEST", "not success" + response.errorBody().string());
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
////                            try {
////                                JSONObject responseJson = new JSONObject(response.message());
////                            } catch (JSONException e) {
////                                Log.d("APITEST", e.getMessage());
////                            }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<String> call, Throwable t) {
//                        Log.d("APITEST", "faild" + t.getMessage());
//                    }
//                });
//
//            }
//        });
//        return v;

}
