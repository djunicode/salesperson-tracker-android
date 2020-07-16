package io.github.djunicode.salespersontracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    TextView signup_link;

    EditText email;
    EditText pass;

    SharedPreferences LoginToken;
    // AUTH TOKEN HERE
    Button btn_login;
    String EmailEntered;
    String PasswordEntered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        email = findViewById( R.id.editEmail );
        pass = findViewById( R.id.editPass );
        signup_link = findViewById( R.id.link_signup );
        signup_link.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( LoginActivity.this, SignupActivity.class);

                startActivity( intent );
            }
        } );


        btn_login=findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmailEntered= email.getText().toString();
                PasswordEntered= pass.getText().toString();

                if (EmailEntered==null || PasswordEntered==null)
                {
                    Toast.makeText(getApplicationContext(),"All fields are Compulsory",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),EmailEntered+PasswordEntered,Toast.LENGTH_LONG).show();



                     RequestBody requestUsername=RequestBody.create(MediaType.parse("multipart/form-data"),EmailEntered);

                    RequestBody requestPassword=RequestBody.create(MediaType.parse("multipart/form-data"),PasswordEntered);


               Retrofit retrofit=new Retrofit.Builder()
                            .baseUrl("http://jash271.pythonanywhere.com")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    ApiInterfaceLogin apiInterfaceLogin =
                            retrofit.create(ApiInterfaceLogin.class);
                    Call<LoginResponseModel> callLogin=apiInterfaceLogin.LoginMethod(requestUsername,requestPassword);
                    callLogin.enqueue(new Callback<LoginResponseModel>() {
                        @Override
                        public void onResponse(Call<LoginResponseModel> call,
                                Response<LoginResponseModel> response) {
                            if(response.isSuccessful())
                            {

                              int mFlag  = response.body().getFlag();
                              String mName= response.body().getName();
                              String mToken= response.body().getToken();
                              String mPhoto = response.body().getPhoto();
                                String mlat= String.valueOf(response.body().getLat());
                                String mlong= String.valueOf(response.body().getLong());

                                Log.d("SUCCESS",String.valueOf(mFlag));
                                Log.d("SUCCESS",mName);
                                Log.d("SUCCESS",mToken);
                                Log.d("SUCCESS",mPhoto);
                                Log.d("SUCCESS",mlat);
                                Log.d("SUCCESS",mlong);
                                LoginToken = getSharedPreferences("AutnTokenLogin", MODE_PRIVATE);
                                SharedPreferences.Editor e = LoginToken.edit();
                                e.putString("Auth Token",  mToken);
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));


                            }
                            else{
                                String resError= response.errorBody().toString();
                                Log.d("FAIL",response.headers().toString());

                             //   Log.d("FAIL", response.body().toString());
                                Log.d("FAIL", response.message());

                                Log.d("FAIL",resError);
                                Toast.makeText(getApplicationContext(),resError,Toast.LENGTH_LONG).show();
                                Toast.makeText(getApplicationContext(),"Error Occured onResponse",Toast.LENGTH_LONG).show();

                            }

                        }
                        @Override
                        public void onFailure(Call<LoginResponseModel> call, Throwable t)
                        {

                            Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                            Log.i("SEE",t.fillInStackTrace().getLocalizedMessage());

                            t.printStackTrace();

                            Toast.makeText(getApplicationContext(),t.fillInStackTrace().getLocalizedMessage(),Toast.LENGTH_LONG).show();
                            Toast.makeText(getApplicationContext(),t.fillInStackTrace().toString(),Toast.LENGTH_LONG).show();

                            Toast.makeText(getApplicationContext(), t.getStackTrace().toString(),Toast.LENGTH_LONG).show();

                            Toast.makeText(getApplicationContext(),"Error occured while connecting to the server",Toast.LENGTH_LONG).show();

                        }
                    });
                }
            }
        });

    }
}
