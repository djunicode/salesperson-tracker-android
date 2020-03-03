package com.example.salespersontracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    TextView signup_link;
    EditText email;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.login );

        email = findViewById( R.id.editEmail );
        pass = findViewById( R.id.editPass );
        signup_link = findViewById( R.id.link_signup );
        signup_link.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Signup.class);

                startActivity( intent );
            }
        } );

    }
}
