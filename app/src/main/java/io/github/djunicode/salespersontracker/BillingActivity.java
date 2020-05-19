package io.github.djunicode.salespersontracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BillingActivity extends AppCompatActivity {
private TextView quant,title,info;
private EditText customerEmail,customerName;
private Button generateBillBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);
        quant=findViewById(R.id.productQuantity);
        title=findViewById(R.id.productName);
        info=findViewById(R.id.productInfo);
        customerEmail=findViewById(R.id.emailEt);
        customerName=findViewById(R.id.nameEt);
        generateBillBtn=findViewById(R.id.generateBillBtn);
        getSupportActionBar().setTitle("Bill");

        Intent intent=getIntent();
        String mTitle=intent.getStringExtra("iTitle");
        String mInfo=intent.getStringExtra("iInfo");
        String mQuant=intent.getStringExtra("iQuantity");

        quant.setText(quant.getText()+mQuant);
        title.setText(title.getText()+mTitle);
        info.setText(info.getText()+mInfo);

    }
}
