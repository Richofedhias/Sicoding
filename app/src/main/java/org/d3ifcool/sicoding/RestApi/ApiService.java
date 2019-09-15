package org.d3ifcool.sicoding.RestApi;

import org.d3ifcool.sicoding.register.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("Register.php")
    Call<User> registerRequest(
      @Field("nama_user") String nama_user,
      @Field("email_user") String email_user,
      @Field("password_user") String password_user);
//      @Field("hobby_user") String password_user_final);
//      @Field("deskripsi_user") String password_user_final);
//      @Field("mmotto_user") String password_user_final);
//      @Field("ketrampilan_user1") String password_user_final);
//      @Field("ketrampilan_user2") String password_user_final);
//      @Field("ketrampilan_user3") String password_user_final);
//      @Field("sampul_profile") String password_user_final);
//
}
