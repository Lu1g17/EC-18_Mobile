package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationPassword extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_password);

        ImageButton Bregistration2= (ImageButton) findViewById(R.id.GoImageButtonRegistrationPassword);

        Bregistration2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registration2 = new Intent(RegistrationPassword.this, Registration.class);

                startActivity(registration2);
            }
        });

    }
}
