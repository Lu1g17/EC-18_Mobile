package com.example.home.Boundary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button Bregistration= findViewById(R.id.buttonRegistrati);

        Bregistration.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent Registration = new Intent(Login.this, RegistrationEmail.class);

                startActivity(Registration);
            }
        });

        Button Baccedi= findViewById(R.id.buttonAccedi);

        Baccedi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent Registration = new Intent(Login.this, MainActivity.class);

                startActivity(Registration);
            }
        });
    }
}