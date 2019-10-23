package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Registration2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration2);

        ImageButton Bregistration2= (ImageButton) findViewById(R.id.imageButtonAvanti2);

        Bregistration2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registration2 = new Intent(Registration2.this, Registration3.class);

                startActivity(registration2);
            }
        });

    }
}