package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration1);
        setContentView(R.layout.registration2);
        setContentView(R.layout.registration3);

        ImageButton Bregistration1= findViewById(R.id.imageButtonAvanti1);

        Bregistration1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent Login = new Intent(Registration.this, Registration.class);

                startActivity(Login);
            }
        });

        ImageButton Bregistration2= findViewById(R.id.imageButtonAvanti2);

        Bregistration2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent Login = new Intent(Registration.this, Registration.class);

                startActivity(Login);
            }
        });

        ImageButton Bregistration3= findViewById(R.id.imageButtonAvanti3);

        Bregistration3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent Login = new Intent(Registration.this, Registration.class);

                startActivity(Login);
            }
        });
    }

}
