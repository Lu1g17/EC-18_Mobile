package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Registration3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration3);

        ImageButton Bregistration3= (ImageButton) findViewById(R.id.imageButtonAvanti3);

        Bregistration3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Intent registration3 = new Intent(Registration3.this, Registration.class);

                //startActivity(registration3);
            }
        });
    }
}
