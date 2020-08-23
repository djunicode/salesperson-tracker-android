package io.github.djunicode.salespersontracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BillingActivity extends AppCompatActivity {
private TextView quant,title,info;
private EditText customerEmail,customerContact;
private Button buyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);
        quant=findViewById(R.id.productQuantity);
        title=findViewById(R.id.productName);
        info=findViewById(R.id.productInfo);
        customerEmail=findViewById(R.id.emailEt);
        customerContact=findViewById(R.id.contactEt);
        buyBtn=findViewById(R.id.buyBtn);
        getSupportActionBar().setTitle("Bill");

        Intent intent=getIntent();
        String mTitle=intent.getStringExtra("iTitle");
        String mInfo=intent.getStringExtra("iInfo");
        String mQuant=intent.getStringExtra("iQuantity");

        quant.setText(quant.getText()+mQuant);
        title.setText(title.getText()+mTitle);
        info.setText(info.getText()+mInfo);

        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String softCopy = "softCopyOfBill";
                int targetRef = 1;
                int salespersonRef = 1;
                int itemRef = 1;

                if(customerContact.getText().toString().isEmpty() || customerEmail.getText().toString().isEmpty())
                {
                    Toast.makeText(BillingActivity.this, "Please enter all fields!",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RequestBody requestIssuedTo = RequestBody.create(MediaType.parse("multipart/form-data"),ApplicationClass.getSalespersonName());
                    RequestBody requestQuantity = RequestBody.create(MediaType.parse("multipart/form-data"),mQuant);
                    RequestBody requestBuyerContact = RequestBody.create(MediaType.parse("multipart/form-data"),
                            customerContact.getText().toString().trim());
                    RequestBody requestBuyerEmail = RequestBody.create(MediaType.parse("multipart/form-data"),
                            customerEmail.getText().toString().trim());
                    RequestBody requestSoftCopy = RequestBody.create(MediaType.parse("multipart/form-data"),softCopy);
                    RequestBody requestTargetRef = RequestBody.create(MediaType.parse("multipart/form-data"),Integer.toString(targetRef));
                    RequestBody requestSalespersonRef = RequestBody.create(MediaType.parse("multipart/form-data"),Integer.toString(salespersonRef));
                    RequestBody requestItemRef = RequestBody.create(MediaType.parse("multipart/form-data"),Integer.toString(itemRef));

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://127.0.0.1:8000")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    ApiInterfaceBill apiInterfaceBill = retrofit.create(ApiInterfaceBill.class);

                    Call<BillResponseModel> callBill = apiInterfaceBill.billMethod(requestIssuedTo,
                            requestQuantity, requestBuyerContact, requestBuyerEmail, requestSoftCopy,
                            requestTargetRef, requestSalespersonRef, requestItemRef);

                    callBill.enqueue(new Callback<BillResponseModel>() {
                        @Override
                        public void onResponse(Call<BillResponseModel> call, Response<BillResponseModel> response) {
                            if(response.isSuccessful())
                            {
                                int id = response.body().getId();
                                String issuedTo = response.body().getIssuedTo();
                                int quantity = response.body().getQuantity();
                                long buyerContact = response.body().getBuyerContact();
                                String buyerEmail = response.body().getBuyerEmail();
                                String softCopy = response.body().getSoftCopy();
                                int targetRef = response.body().getTargetRef();
                                int itemRef = response.body().getItemRef();
                                int salespersonRef = response.body().getSalespersonRef();

                                Toast.makeText(BillingActivity.this, "Success!",
                                        Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
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
                        public void onFailure(Call<BillResponseModel> call, Throwable t) {
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
