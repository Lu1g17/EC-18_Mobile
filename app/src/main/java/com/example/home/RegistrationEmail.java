package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationEmail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_email);
        //setContentView(R.layout.registration);

        ImageButton Bregistration1 = (ImageButton) findViewById(R.id.imageButtonAvanti1);

        Bregistration1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registration2 = new Intent(RegistrationEmail.this, RegistrationPassword.class);

                startActivity(registration2);
            }
        });

        /*

        ImageButton Bregistration3= (ImageButton) findViewById(R.id.imageButtonAvanti3);

        Bregistration3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registration = new Intent(Registration.this, Registration.class);

                startActivity(registration);
            }
        });*/

    }
}


