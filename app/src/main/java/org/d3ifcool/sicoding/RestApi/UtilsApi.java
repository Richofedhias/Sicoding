package org.d3ifcool.sicoding.RestApi;

public class UtilsApi {
    public static final String BASE_URL_API = "";

    public static ApiService getAPIService() {
        return RetrofitClient.getClient(BASE_URL_API).create(ApiService.class);
    }
}
