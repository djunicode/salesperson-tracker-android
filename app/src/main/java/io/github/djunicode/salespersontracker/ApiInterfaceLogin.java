package io.github.djunicode.salespersontracker;

import okhttp3.RequestBody;

import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterfaceLogin {
    @Multipart
    @POST("/Operations/SignIn")
    Call<LoginResponseModel> LoginMethod (
            @Part ("Username") RequestBody Username,
            @Part ("Password") RequestBody Password
    );
}
