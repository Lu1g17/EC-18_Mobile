package com.example.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        ImageButton Bregistration3= (ImageButton) findViewById(R.id.GoImageButtonRegistration);

        Bregistration3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Intent registration = new Intent(Registration.this, Registration.class);

                //startActivity(registration);
            }
        });
    }
}
