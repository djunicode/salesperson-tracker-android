package io.github.djunicode.salespersontracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView signup_link;
    EditText email;
    EditText pass;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        email = findViewById( R.id.editEmail );
        pass = findViewById( R.id.editPass );
        signup_link = findViewById( R.id.link_signup );
        loginBtn=findViewById(R.id.btn_login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,ItemListActivity.class));
            }
        });
        signup_link.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( LoginActivity.this, SignupActivity.class);

                startActivity( intent );
            }
        } );

    }
}
