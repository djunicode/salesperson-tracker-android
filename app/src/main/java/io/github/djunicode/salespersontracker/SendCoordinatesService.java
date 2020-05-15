package io.github.djunicode.salespersontracker;

import android.content.SharedPreferences;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface SendCoordinatesService {

    @FormUrlEncoded
    @POST("GetCoordinates")
    Call<ResponseBody> sendCoordinates(
            @Header("Authorization") String header,
            @Field("id") String id, @Field("Lat") String latitude, @Field("Long") String longitude);
}
