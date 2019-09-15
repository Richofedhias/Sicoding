package org.d3ifcool.sicoding.RestApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UtilsApi {
    public static final String BASE_URL_API = "https://sicoding1602.000webhostapp.com/";
    private static Retrofit retrofit;

    public static Retrofit getAPIService() {

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
